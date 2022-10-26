package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataHelper {

    /**
     * Валидный идентификатор питомца
     */
    public static final String VALID_PET_ID = "0";

    /**
     * Валидный идентификатор магазина
     */
    public static final String VALID_STORE_ID = "0";

    /**
     * Не валидный идентификатор питомца
     */
    public static final String NOT_VALID_ID = "dfadff";

    /**
     * Валидный идентификатор категории
     */
    public static final String VALID_CATEGORY_ID = "0";

    /**
     * Валидный идентификатор тэга
     */
    public static final String VALID_TAG_ID = "0";

    /**
     * Валидное имя тэга
     */
    public static final String VALID_TAG_NAME = "tagOne";

    /**
     * Валидный статус питомца
     */
    public static final String VALID_STATUS = "available";

    /**
     * Статус код успешного результата запроса
     */
    public static final int STATUS_CODE_OK = 200;

    /**
     * Статус код не успешного результата запроса
     */
    public static final int STATUS_CODE_ERROR_500 = 500;

    /**
     * Статус код не успешного запроса
     */
    public static final int STATUS_CODE_ERROR_404 = 404;
    /**
     * Валидный статус магазина
     */
    public static final String STATUS_STORE = "placed";
    /**
     * Экземпляр класса Faker
     */
    private static final Faker faker = new Faker();
    /**
     * Регулярное выражениек для генерации случайного URL
     */
    private static final String REGEXP_PHOTO_URL = "http:\\\\[a-z]{5}";
    /**
     * Регулярное выражениек для генерации случайного не валидного статуса
     */
    private static final String REGEXP_NOT_VALID_STATUS = "[a-z]{20}";
    /**
     * Регулярное выражениек для генерации случайного числа
     */
    private static final String REGEXP_NUMBER = "[0-9]{10}";
    /**
     * Регулярное выражениек для генерации случайного числа quantity
     */
    private static final String REGEXP_NUMBER_QUANTITY = "[0-9]{5}";

    /**
     * Метод получения случайного имени питомца
     *
     * @return случайное имя питомца
     */
    public static String getRandomPetName() {
        return faker.dog().name();
    }

    /**
     * Метод получения случайного имени категории
     *
     * @return случайное имя категории
     */
    public static String getRandomCategoryName() {
        return faker.dog().breed();
    }

    /**
     * Метод получения случайного URL
     *
     * @return случайное URL
     */
    public static String getRandomUrl() {
        return faker.regexify(REGEXP_PHOTO_URL);
    }

    /**
     * Метод получения случайного не валидного статуса
     *
     * @return случайный не валидный статус
     */
    public static String getRandomNotValidStatus() {
        return faker.regexify(REGEXP_NOT_VALID_STATUS);
    }

    /**
     * Метод получения случайного числа
     *
     * @return случайное число
     */
    public static String getRandomNumber() {
        return faker.regexify(REGEXP_NUMBER);
    }

    /**
     * Метод получения случайного числа Quantity
     *
     * @return случайное число
     */
    public static String getRandomNumberQuantity() {
        return faker.regexify(REGEXP_NUMBER_QUANTITY);
    }

    /**
     * Метод получения текущей даты и времени
     *
     * @return текущая дата и время
     */
    public static String getDate() {
        String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        return date;
    }
}
