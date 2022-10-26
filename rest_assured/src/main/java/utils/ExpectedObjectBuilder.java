package utils;

import dto.response.ErrorResponse;

/**
 * Вспомогательный класс для формирования ожидаемых результатов
 */
public class ExpectedObjectBuilder {

    /**
     * Код успешного ответа
     */
    private static final int CODE = 200;

    /**
     * Код неизвестной ошибки
     */
    private static final int UNKNOWN_CODE = 500;

    /**
     * Код неизвестной ошибки
     */
    private static final int WRONG_FORMAT_CODE = 404;

    /**
     * Тип неизвестной ошибки
     */
    private static final String UNKNOWN_TYPE = "unknown";

    /**
     * Тип неизвестной ошибки error
     */
    private static final String ERROR_TYPE = "error";

    /**
     * Сообщение неизвестной ошибки
     */
    private static final String UNKNOWN_MESSAGE = "something bad happened";

    /**
     * Сообщение неизвестной ошибки error
     */
    private static final String ERROR_MESSAGE = "Pet not found";

    /**
     * Метод формирования ожидаемого результата неизвестной ошибки
     *
     * @return тело ошибки
     */
    public static ErrorResponse getUnknownErrorResponse() {
        return ErrorResponse.builder()
                .code(UNKNOWN_CODE)
                .type(UNKNOWN_TYPE)
                .message(UNKNOWN_MESSAGE)
                .build();
    }

    /**
     * Метод формирования ожидаемого результата ошибки c неверным форматом параметра запроса
     *
     * @return тело ошибки
     */
    public static ErrorResponse getWrongFormatErrorResponse(String notValidPetId) {
        return ErrorResponse.builder()
                .code(WRONG_FORMAT_CODE)
                .type(UNKNOWN_TYPE)
                .message("java.lang.NumberFormatException: For input string: \"" + notValidPetId + "\"")
                .build();
    }

    /**
     * Метод формирования ожидаемого результата запроса после удаления питомца
     *
     * @return тело ответа
     */
    public static ErrorResponse getDeleteResponse(String id) {
        return ErrorResponse.builder()
                .code(CODE)
                .type(UNKNOWN_TYPE)
                .message(id)
                .build();
    }

    /**
     * Метод формирования ожидаемого результата ошибки c несуществующим id
     *
     * @return тело ошибки
     */
    public static ErrorResponse getNotIdErrorResponse() {
        return ErrorResponse.builder()
                .code(1)
                .type(ERROR_TYPE)
                .message(ERROR_MESSAGE)
                .build();
    }
}
