import database.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestObjectBuilder.getRandomUserModel;

public class UserTest extends BaseTest {

    /**
     * Модель объекта
     */
    private UserModel user;

    private int id;

    @BeforeEach
    public void setUpClass() {
        user = getRandomUserModel();
        steps.createUser(user);
        List<UserModel> list = steps.getAllUser();
        for (UserModel element : list) {
            if (element.getNickName().equals(user.getNickName())) {
                id = element.getId();
            }
        }
    }

    @Test
    @DisplayName("Создание User в базе данных")
    public void creatingUserInDataBase() {
        //user = getRandomUserModel();
        boolean isCreated = false;
        int id = -1;

        //steps.createUser(user);

        List<UserModel> list = steps.getAllUser();
        for (UserModel element : list) {
            id = element.getId();
            isCreated = true;
            if (element.getNickName().equals(user.getNickName())) {
                assertThat(element)
                        .isEqualTo(user);
            }
        }

        assertThat(isCreated)
                .withFailMessage("User wasn't create")
                .isTrue();

        steps.deleteUser(id);
    }

    @Test
    @DisplayName("Чтение User в базе данных")
    public void readingUserInDataBase() {

        UserModel actual = steps.getUserById(id);

        assertThat(actual)
                .isEqualTo(user);
        steps.deleteUser(id);
    }

    @Test
    @DisplayName("Обновление User в базе данных")
    public void updateUserInDataBase() {
        user = getRandomUserModel();

        steps.updateUser(user, id);

        UserModel actualUser = steps.getUserById(id);

        assertThat(actualUser)
                .isEqualTo(user);
        steps.deleteUser(id);
    }

    @Test
    @DisplayName("Удаление User из базы")
    public void deleteUserInDataBase() {
        boolean isDeleted = true;

        steps.deleteUser(id);

        List<UserModel> listAfterDelete = steps.getAllUser();
        for (UserModel element : listAfterDelete) {
            if (element.getNickName().equals(user.getNickName())) {
                isDeleted = false;
                break;
            }
        }

        assertThat(isDeleted)
                .withFailMessage("User wasn't delete")
                .isTrue();
    }
}