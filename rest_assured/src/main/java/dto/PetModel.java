package dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class PetModel {

    private final String id;
    private final CategoryAndTagsItem category;
    private final String name;
    private final List<String> photoUrls;
    private final List<CategoryAndTagsItem> tags;
    private final String status;

    @Data
    @Builder
    public static class CategoryAndTagsItem {
        private final String id;
        private final String name;
    }
}