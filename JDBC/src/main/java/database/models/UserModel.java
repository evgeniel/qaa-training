package database.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Модель сущность user базы данных
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class UserModel {

    /**
     * Идентификатор
     */
    private final int id;

    /**
     * Имя
     */
    private final String nickName;

    /**
     * Почта
     */
    private final String email;

    /**
     * Пароль
     */
    private final String pass;

    /**
     * Дата рождения
     */
    private final LocalDate birthDate;

    /**
     * Пол
     */
    private final String isMale;
}
