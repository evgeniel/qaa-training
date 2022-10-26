package utils;

import dto.PetModel;
import dto.StoreModel;

import java.util.List;

import static utils.TestDataHelper.*;

/**
 * Вспомагательный класс для формирования тестовых объектов
 */
public class TestObjectBuilder {

    /**
     * Метод для формирования тела запроса создания питомца
     *
     * @param id идентификатор питомца
     * @return тело запроса
     */
    public static PetModel getAddNewPetModel(String id) {
        return PetModel.builder()
                .id(id)
                .category(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_CATEGORY_ID)
                        .name(getRandomCategoryName())
                        .build())
                .name(getRandomPetName())
                .photoUrls(List.of(getRandomUrl()))
                .tags(List.of(PetModel.CategoryAndTagsItem.builder()
                        .id(VALID_TAG_ID)
                        .name(VALID_TAG_NAME)
                        .build()))
                .status(VALID_STATUS)
                .build();
    }

    /**
     * Метод для формирования тела запроса создания магазина
     *
     * @return тело запроса
     */
    public static StoreModel getAddNewStoreModel(String id) {
        return StoreModel.builder()
                .id(id)
                .petId(getRandomNumber())
                .quantity(getRandomNumberQuantity())
                .shipDate(getDate())
                .status(STATUS_STORE)
                .complete(true)
                .build();
    }
}
