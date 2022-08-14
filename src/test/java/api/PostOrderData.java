package api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PostOrderData {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public PostOrderData(Integer id, Integer petId, Integer quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }
}
