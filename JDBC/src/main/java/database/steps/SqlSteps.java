package database.steps;

import database.models.PostModel;
import database.models.UserModel;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс с реализацией Sql шагов
 */
@AllArgsConstructor
public class SqlSteps {

    private static final String ID_FIELD = "id";
    private static final String NICK_NAME_FIELD = "nick_name";
    private static final String EMAIL_FIELD = "email";
    private static final String PASS_FIELD = "pass";
    private static final String BIRTHDAY_FIELD = "birthdate";
    private static final String IS_MALE_FIELD = "is_male";

    private static final String ID_FIELD_POST = "id";
    private static final String USER_ID_FIELD = "user_id";
    private static final String TITLE_FIELD = "title";
    private static final String POST_TEXT_FIELD = "post_text";
    private static final String POST_DATE_FIELD = "post_date";

    private static final String INSERT_SQL_QUERY = "INSERT INTO users (%s, %s, %s, %s, %s)" +
            "VALUES (\"%s\",\"%s\",\"%s\",\"%s\",\"%s\")";

    private static final String INSERT_SQL_QUERY_POST = "INSERT INTO posts (%s, %s, %s, %s)" +
            "VALUES (\"%s\",\"%s\",\"%s\",\"%s\")";

    private static final String UPDATE_SQL_REQUEST = "UPDATE users " +
            "SET %s = \"%s\", %s = \"%s\", %s = \"%s\", %s = \"%s\", %s = \"%s\" " +
            "WHERE %s = %d";

    private static final String UPDATE_SQL_REQUEST_POST = "UPDATE posts " +
            "SET %s = \"%s\", %s = \"%s\", %s = \"%s\" " +
            "WHERE %s = %d";

    private static final String DELETE_SQL_REQUEST = "DELETE FROM users WHERE %s = %d";

    private static final String DELETE_SQL_REQUEST_POST = "DELETE FROM posts WHERE %s = %d";

    private static final String SELECT_ALL_SQL_REQUEST = "SELECT * FROM users";

    private static final String SELECT_ALL_SQL_REQUEST_POST = "SELECT * FROM posts";

    private static final String SELECT_BY_ID_SQL_REQUEST = "SELECT * FROM users WHERE %s = %d";

    private static final String SELECT_BY_ID_SQL_REQUEST_POST = "SELECT * FROM posts WHERE %s = %d";

    /**
     * Переменная с подключением к БД
     */
    private final Connection connection;

    /**
     * Метод создания User в БД
     *
     * @param user объект с параметрами для создания
     */
    public void createUser(UserModel user) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(String.format(INSERT_SQL_QUERY,
                    NICK_NAME_FIELD, EMAIL_FIELD, PASS_FIELD, BIRTHDAY_FIELD, IS_MALE_FIELD,
                    user.getNickName(), user.getEmail(), user.getPass(), user.getBirthDate(), user.getIsMale()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обновления User в БД
     *
     * @param user объект с параметрами для обновления
     * @param id   идентификатор поля, которое обновляем
     */
    public void updateUser(UserModel user, int id) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(String.format(UPDATE_SQL_REQUEST,
                    NICK_NAME_FIELD, user.getNickName(),
                    EMAIL_FIELD, user.getEmail(),
                    PASS_FIELD, user.getPass(),
                    BIRTHDAY_FIELD, user.getBirthDate(),
                    IS_MALE_FIELD, user.getIsMale(),
                    ID_FIELD, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаления User в БД
     *
     * @param id идентификатор поля, которое удаляем
     */
    public void deleteUser(int id) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(String.format(DELETE_SQL_REQUEST, ID_FIELD, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод запроса всех User из БД
     *
     * @return список всех User
     */
    public List<UserModel> getAllUser() {
        List<UserModel> list = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery(SELECT_ALL_SQL_REQUEST);
            while (result.next()) {
                list.add(UserModel.builder()
                        .id(result.getInt(ID_FIELD))
                        .nickName(result.getString(NICK_NAME_FIELD))
                        .email(result.getString(EMAIL_FIELD))
                        .pass(result.getString(PASS_FIELD))
                        .birthDate(result.getObject(BIRTHDAY_FIELD, LocalDate.class))
                        .isMale(result.getString(IS_MALE_FIELD))
                        .build()
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }

    /**
     * Метод запроса User по ID из БД
     *
     * @param id идентификатор поля
     * @return объект User
     */
    public UserModel getUserById(int id) {
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery(String.format(SELECT_BY_ID_SQL_REQUEST, ID_FIELD, id));
            if (result.next()) {
                return UserModel.builder()
                        .id(result.getInt(ID_FIELD))
                        .nickName(result.getString(NICK_NAME_FIELD))
                        .email(result.getString(EMAIL_FIELD))
                        .pass(result.getString(PASS_FIELD))
                        .birthDate(result.getObject(BIRTHDAY_FIELD, LocalDate.class))
                        .isMale(result.getString(IS_MALE_FIELD))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Метод создания Post в БД
     *
     * @param post объект с параметрами для создания
     */
    public void createPost(PostModel post, int userId) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(String.format(INSERT_SQL_QUERY_POST,
                    USER_ID_FIELD, TITLE_FIELD, POST_TEXT_FIELD, POST_DATE_FIELD,
                    userId, post.getTitle(), post.getPostText(), post.getPostDate()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод обновления Post в БД
     *
     * @param post объект с параметрами для обновления
     * @param id   идентификатор поля, которое обновляем
     */
    public void updatePost(PostModel post, int id) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(String.format(UPDATE_SQL_REQUEST_POST,
                    TITLE_FIELD, post.getTitle(),
                    POST_TEXT_FIELD, post.getPostText(),
                    POST_DATE_FIELD, post.getPostDate(),
                    ID_FIELD_POST, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод удаления Post в БД
     *
     * @param id идентификатор поля, которое удаляем
     */
    public void deletePost(int id) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(String.format(DELETE_SQL_REQUEST_POST, ID_FIELD_POST, id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод запроса всех Post из БД
     *
     * @return список всех Post
     */
    public List<PostModel> getAllPost() {
        List<PostModel> list = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery(SELECT_ALL_SQL_REQUEST_POST);
            while (result.next()) {
                list.add(PostModel.builder()
                        .id(result.getInt(ID_FIELD_POST))
                        .userId(result.getInt(USER_ID_FIELD))
                        .title(result.getString(TITLE_FIELD))
                        .postText(result.getString(POST_TEXT_FIELD))
                        .postDate(result.getObject(POST_DATE_FIELD, LocalDate.class))
                        .build()
                );
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }

    /**
     * Метод запроса Post по ID из БД
     *
     * @param id идентификатор поля
     * @return объект Post
     */
    public PostModel getPostById(int id) {
        try (Statement stmt = connection.createStatement()) {
            ResultSet result = stmt.executeQuery(String.format(SELECT_BY_ID_SQL_REQUEST_POST, ID_FIELD_POST, id));
            if (result.next()) {
                return PostModel.builder()
                        .id(result.getInt(ID_FIELD_POST))
                        .userId(result.getInt(USER_ID_FIELD))
                        .title(result.getString(TITLE_FIELD))
                        .postText(result.getString(POST_TEXT_FIELD))
                        .postDate(result.getObject(POST_DATE_FIELD, LocalDate.class))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
