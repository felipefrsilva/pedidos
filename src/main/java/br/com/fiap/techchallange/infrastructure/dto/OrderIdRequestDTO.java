package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class OrderIdRequestDTO {

    @Schema(name = "orderId", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String orderId;

    public OrderIdRequestDTO(){}

    public OrderIdRequestDTO(String orderId) {
        this.setOrderId(orderId);
    }

    public String getOrderId() {
        return orderId;
    }

    private void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
