package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class OrderIdDTO {

    @Schema(name = "orderId", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String orderId;

    public OrderIdDTO(){}

    public OrderIdDTO(String orderId) {
        this.setOrderId(orderId);
    }

    public String getOrderId() {
        return orderId;
    }

    private void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
