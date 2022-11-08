import database.models.PostModel;
import database.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestObjectBuilder.getRandomPostModel;
import static utils.TestObjectBuilder.getRandomUserModel;

public class PostTest extends BaseTest {

    /**
     * Модель объекта
     */
    private UserModel user;
    private PostModel post;

    private int id;

    @BeforeEach
    public void setUpClass() {
        user = getRandomUserModel();
        steps.createUser(user);
        int userId = -1;
        List<UserModel> list = steps.getAllUser();
        for (UserModel element : list) {
            if (element.getNickName().equals(user.getNickName())) {
                userId = element.getId();
            }
        }

        post = getRandomPostModel();
        steps.createPost(post, userId);
        List<PostModel> listPost = steps.getAllPost();
        for (PostModel element : listPost) {
            if (element.getTitle().equals(post.getTitle())) {
                id = element.getId();
            }
        }
    }

    @Test
    @DisplayName("Создание Post в базе данных")
    public void creatingPostInDataBase() {

        boolean isCreated = false;
        int id = -1;


        List<PostModel> list = steps.getAllPost();
        for (PostModel element : list) {
            id = element.getId();
            isCreated = true;
            if (element.getTitle().equals(post.getTitle())) {
                assertThat(element)
                        .isEqualTo(post);
            }
        }

        assertThat(isCreated)
                .withFailMessage("User wasn't create")
                .isTrue();

        steps.deletePost(id);
    }

    @Test
    @DisplayName("Чтение Post в базе данных")
    public void readingPostInDataBase() {

        PostModel actual = steps.getPostById(id);

        assertThat(actual)
                .isEqualTo(post);
        steps.deletePost(id);
    }

    @Test
    @DisplayName("Обновление Post в базе данных")
    public void updatePostInDataBase() {
        post = getRandomPostModel();

        steps.updatePost(post, id);

        PostModel actualPost = steps.getPostById(id);

        assertThat(actualPost)
                .isEqualTo(post);
        steps.deletePost(id);
    }

    @Test
    @DisplayName("Удаление Post из базы")
    public void deletePostInDataBase() {
        boolean isDeleted = true;

        steps.deletePost(id);

        List<PostModel> listAfterDelete = steps.getAllPost();
        for (PostModel element : listAfterDelete) {
            if (element.getTitle().equals(post.getTitle())) {
                isDeleted = false;
                break;
            }
        }

        assertThat(isDeleted)
                .withFailMessage("User wasn't delete")
                .isTrue();
    }
}
