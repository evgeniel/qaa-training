import base.BaseTest;
import dto.PetModel;
import dto.response.ErrorResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.ResponseWrapper;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.ExpectedObjectBuilder.getUnknownErrorResponse;
import static utils.TestDataHelper.*;
import static utils.TestObjectBuilder.getAddNewPetModel;

/**
 * Тест сьют метода PUT /pet
 */
@Epic("Pet контроллер")
@Feature("Update pet to store")
public class UpdatePetToStore extends BaseTest {

    @Test
    @DisplayName("Update pet to store. Positive case")
    @Story("Редактирование питомца, позитивный сценарий")
    public void testUpdatePetToStorePositive() {

        step("Создание тела запроса и выполнение запроса POST /pet", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
            responseWrapper = steps.createNewPetToStore(request);
        });

        step("Создание тела запроса с валидным ID", () -> {
            request = responseWrapper.as(PetModel.class);
            request = getAddNewPetModel(request.getId());
        });

        step("Выполнение запроса PUT /pet", () -> {
            responseWrapper = steps.updatePetToStore(request);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetModel response = responseWrapper.as(PetModel.class);
            ResponseWrapper responseGetPetById = steps.getPetById(response.getId());
            PetModel resp = responseGetPetById.as(PetModel.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(resp);
                    }
            );
        });
    }

    @Test
    @DisplayName("Update pet to store. Negative case with not valid ID")
    @Story("Редактирование питомца с не валидным ID, негативный сценарий")
    public void testUpdatePetToStoreNegative() {

        step("Создание тела запроса с валидным ID", () -> {
            request = getAddNewPetModel(NOT_VALID_ID);
        });

        step("Выполнение запроса PUT /pet", () -> {
            responseWrapper = steps.updatePetToStore(request);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_500);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getUnknownErrorResponse());
                    }
            );
        });
    }
}
