import base.BaseTest;
import dto.StoreModel;
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
import static utils.TestObjectBuilder.getAddNewStoreModel;

/**
 * Тест сьют метода POST /store/order
 */
@Epic("Store контроллер")
@Feature("Add new store to pet")
public class AddNewStoreToPet extends BaseTest {

    @Test
    @DisplayName("Add new store to pet. Positive case")
    @Story("Добавление магазина для питомца, позитивный сценарий")
    public void testAddNewStoreToPetPositive() {

        step("Создание тела запроса с валидным ID", () -> {
            requestStore = getAddNewStoreModel(VALID_STORE_ID);
        });

        step("Выполнение запроса POST /store/order", () -> {
            responseWrapper = steps.createNewStoreToPet(requestStore);
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            StoreModel response = responseWrapper.as(StoreModel.class);
            ResponseWrapper responseGetStoreOrderId = steps.getStoreById(response.getId());
            StoreModel resp = responseGetStoreOrderId.as(StoreModel.class);

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
    @DisplayName("Add new store to pet. Negative case with not valid PetID")
    @Story("Добавление магазина для питомца с не валидным PetID, негативный сценарий")
    public void testAddNewStoreToPetNegative() {

        step("Создание тела запроса с валидным ID", () -> {
            requestStore = getAddNewStoreModel(NOT_VALID_ID);
        });

        step("Выполнение запроса POST /store/order", () -> {
            responseWrapper = steps.createNewStoreToPet(requestStore);
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
