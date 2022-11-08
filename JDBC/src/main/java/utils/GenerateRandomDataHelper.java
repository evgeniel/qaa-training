package utils;

import com.github.javafaker.Faker;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Random;

/**
 * Класс с методами создания рандомных данных
 */
@UtilityClass
public class GenerateRandomDataHelper {

    private static final Faker faker = new Faker();

    private static final String EMAIL_REGEXP = "[a-z]{10}\\@[a-z]{5}\\.[a-z]{2}";

    private static final String PASSWORD_REGEXP = "[a-z]{5}[0-9]{5}";

    private static final String TITLE_REGEXP = "[a-z]{15}";

    private static final String TEXT_REGEXP = "[a-z]{100}";

    /**
     * Метода генерации случайной фамилии
     *
     * @return случайную фамилию
     */
    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    /**
     * Метода генерации случайного имени
     *
     * @return случайное имя
     */
    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    /**
     * Метода генерации случайного email
     *
     * @return случайный email
     */
    public static String getRandomEmail() {
        return faker.regexify(EMAIL_REGEXP);
    }

    /**
     * Метода генерации случайного password
     *
     * @return случайный password
     */
    public static String getRandomPassword() {
        return faker.regexify(PASSWORD_REGEXP);
    }

    /**
     * Метода генерации случайного title
     *
     * @return случайный title
     */
    public static String getRandomTitle() {
        return faker.regexify(TITLE_REGEXP);
    }

    /**
     * Метода генерации случайного postText
     *
     * @return случайный postText
     */
    public static String getRandomPostText() {
        return faker.regexify(TEXT_REGEXP);
    }

    /**
     * Метода генерации случайной даты рождения
     *
     * @return случайная дата рождения
     */
    public static LocalDate getRandomBirthDate() {
        int year = faker.number().numberBetween(1930, 2000);
        int month = faker.number().numberBetween(1, 12);
        int day = faker.number().numberBetween(1, 28);
        return LocalDate.of(year, month, day);
    }

    /**
     * Метода генерации случайного пола
     *
     * @return случайный пол
     */
    public static String getRandomSex() {
        //return faker.gameOfThrones().dragon();
        String[] sex = {"Male", "Female"};
        Random rand = new Random();
        return sex[rand.nextInt(2)];
    }
}