import base.BaseTest;
import dto.PetModel;
import dto.response.ErrorResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.ExpectedObjectBuilder.getNotIdErrorResponse;
import static utils.ExpectedObjectBuilder.getWrongFormatErrorResponse;
import static utils.TestDataHelper.*;
import static utils.TestObjectBuilder.getAddNewPetModel;

/**
 * Тест сьют метода GET /pet/petId
 */
@Epic("Pet контроллер")
@Feature("Find pet by id")
public class FindPetById extends BaseTest {

    @Test
    @DisplayName("Find pet by id. Positive case")
    @Story("Поиск питомца по id, позитивный сценарий")
    public void testFindPetByIdPositive() {

        step("Выполнение запроса POST /pet", () -> {
            request = getAddNewPetModel(VALID_PET_ID);
            responseWrapper = steps.createNewPetToStore(request);
        });

        PetModel responseAddNewPet = responseWrapper.as(PetModel.class);

        step("Выполнение запроса GET /pet/petId", () -> {
            responseWrapper = steps.getPetById(responseAddNewPet.getId());
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            PetModel response = responseWrapper.as(PetModel.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(responseAddNewPet);
                    }
            );
        });
    }

    @Test
    @DisplayName("Find pet by id. Negative case, if id is not valid")
    @Story("Поиск питомца с невалидным id, негативный сценарий")
    public void testFindPetByIdIfNotValidNegative() {

        step("Выполнение запроса GET /pet/petId", () -> {
            responseWrapper = steps.getPetById(NOT_VALID_ID);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_404);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getWrongFormatErrorResponse(NOT_VALID_ID));
                    }
            );
        });
    }

    @Test
    @DisplayName("Find pet by id. Negative case, if id is not existing")
    @Story("Поиск питомца с несуществующим id, негативный сценарий")
    public void testFindPetByIdIfIdNullNegative() {

        step("Выполнение запроса GET /pet/petId", () -> {
            responseWrapper = steps.getPetById(getRandomNumber());
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            ErrorResponse error = responseWrapper.as(ErrorResponse.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_ERROR_404);
                        softAssertions
                                .assertThat(error)
                                .withFailMessage("Error body doesn't match")
                                .isEqualTo(getNotIdErrorResponse());
                    }
            );
        });
    }
}
