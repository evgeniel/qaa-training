package dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = {"id"})
public class StoreModel {
    private final String id;
    private final String petId;
    private final String quantity;
    private final String shipDate;
    private final String status;
    private final Boolean complete;
}
