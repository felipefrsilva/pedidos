package br.com.fiap.techchallange.application.dto;

public class OrderIdDTO {

    private String orderId;

    public OrderIdDTO(String orderId) {
        this.setOrderId(orderId);
    }

    public String getOrderId() {
        return orderId;
    }

    private void setOrderId(String orderId) {
        orderId = orderId;
    }
}
