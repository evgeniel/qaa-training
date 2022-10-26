import base.BaseTest;
import dto.StoreModel;
import dto.response.ErrorResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.ExpectedObjectBuilder.getWrongFormatErrorResponse;
import static utils.TestDataHelper.*;
import static utils.TestObjectBuilder.getAddNewStoreModel;

/**
 * Тест сьют метода GET /store/order/orderId
 */
@Epic("Store контроллер")
@Feature("Find Store by id")
public class FindStoreById extends BaseTest {

    @Test
    @DisplayName("Find store by id. Positive case")
    @Story("Поиск магазина по id, позитивный сценарий")
    public void testFindStoreByIdPositive() {

        step("Выполнение запроса POST /store/order", () -> {
            requestStore = getAddNewStoreModel(VALID_STORE_ID);
            responseWrapper = steps.createNewStoreToPet(requestStore);
        });

        StoreModel responseAddNewStore = responseWrapper.as(StoreModel.class);

        step("Выполнение запроса GET /store/order/orderId", () -> {
            responseWrapper = steps.getStoreById(responseAddNewStore.getId());
        });

        step("Проверка результата", () -> {
            int statusCode = responseWrapper.getStatusCode();
            StoreModel response = responseWrapper.as(StoreModel.class);

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(statusCode)
                                .withFailMessage("Status code doesn't match")
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(response)
                                .withFailMessage("Response body doesn't match")
                                .isEqualTo(responseAddNewStore);
                    }
            );
        });
    }

    @Test
    @DisplayName("Find store by id. Negative case, if id is not valid")
    @Story("Поиск магазина с невалидным id, негативный сценарий")
    public void testFindStoreByIdIfNotValidNegative() {

        step("Выполнение запроса GET /store/order/orderId", () -> {
            responseWrapper = steps.getStoreById(NOT_VALID_ID);
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
}
