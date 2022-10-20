package steps;

import dto.PetModel;
import dto.StoreModel;
import io.restassured.specification.RequestSpecification;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;

/**
 * Класс с реализацией всех Rest шагов
 */
public class Steps {

    /**
     * Часть URL для запросов /pet
     */
    private static final String PET_PATH = "pet/";
    /**
     * Часть URL для запросов /store/order
     */
    private static final String STORE_PATH = "/store/order/";
    /**
     * Часть URL для запросов /findByStatus
     */
    private static final String FIND_BY_STATUS_PATH = "pet/findByStatus";
    /**
     * Параметр status, get запроса findByStatus
     */
    private static final String STATUS_PARAMETER = "status";
    /**
     * Экземпляр спецификации RestAssured
     */
    private final RequestSpecification requestSpecification;

    /**
     * Конструктор для создания экземпляра класса
     *
     * @param requestSpecification спецификация RestAssured
     */
    public Steps(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Метод создания питомца
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper createNewPetToStore(PetModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .post(PET_PATH)
                .andReturn());
    }

    /**
     * Метод создания магазина
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper createNewStoreToPet(StoreModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .post(STORE_PATH)
                .andReturn());
    }

    /**
     * Метод редактирования питомца
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper updatePetToStore(PetModel request) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .body(request)
                .put(PET_PATH)
                .andReturn());
    }

    /**
     * Метод поиска питомцев по статусу
     *
     * @param status статус
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper getPetByStatus(String status) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .param(STATUS_PARAMETER, status)
                .get(FIND_BY_STATUS_PATH)
                .andReturn());
    }

    /**
     * Метод поиска питомца по ID
     *
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper getPetById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .get(PET_PATH + id)
                .andReturn());
    }

    /**
     * Метод удаления питомца по ID
     *
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper deletePetById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .delete(PET_PATH + id)
                .andReturn());
    }

    /**
     * Метод удаления магазина по ID
     *
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper deleteStoreById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .delete(STORE_PATH + id)
                .andReturn());
    }

    /**
     * Метод поиска магазина по ID
     *
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper getStoreById(String id) {
        return new ResponseWrapper(given(requestSpecification)
                .when()
                .get(STORE_PATH + id)
                .andReturn());
    }
}
