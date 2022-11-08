package database.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * Модель сущность post базы данных
 */
@Data
@Builder
@EqualsAndHashCode(exclude = {"id", "userId"})
public class PostModel {

    /**
     * Идентификатор
     */
    private final int id;

    /**
     * Идентификатор user
     */
    private final int userId;

    /**
     * Заголовок
     */
    private final String title;

    /**
     * Текста поста
     */
    private final String postText;

    /**
     * Дата поста
     */
    private final LocalDate postDate;
}
