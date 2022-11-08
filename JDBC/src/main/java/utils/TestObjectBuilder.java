package utils;

import database.models.PostModel;
import database.models.UserModel;
import lombok.experimental.UtilityClass;

import static utils.GenerateRandomDataHelper.*;

/**
 * Класс с методами создания тестовых объектов
 */
@UtilityClass
public class TestObjectBuilder {

    /**
     * Метод генерации случайной User модели
     *
     * @return случайную User модель
     */
    public static UserModel getRandomUserModel() {
        return UserModel.builder()
                .nickName(getRandomFirstName() + " " + getRandomLastName())
                .email(getRandomEmail())
                .pass(getRandomPassword())
                .birthDate(getRandomBirthDate())
                .isMale(getRandomSex())
                .build();
    }

    /**
     * Метод генерации случайной Post модели
     *
     * @return случайную Post модель
     */
    public static PostModel getRandomPostModel() {
        return PostModel.builder()
                .title(getRandomTitle())
                .postText(getRandomPostText())
                .postDate(getRandomBirthDate())
                .build();
    }
}
