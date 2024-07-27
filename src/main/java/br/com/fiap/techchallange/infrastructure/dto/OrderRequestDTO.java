package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class OrderRequestDTO implements Serializable {

    @Schema(name = "id", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String id;
    @Schema(name = "items", example=("[{\"sku\": \"123456A\",\"amount\": 35.00,\"quantity\": 1}]"), required = true)
    private List<ItemRequestDTO> items;

    public OrderRequestDTO(String id, List<ItemRequestDTO> items) {
        this.id = id;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public List<ItemRequestDTO> getItems() {
        return items;
    }
}
