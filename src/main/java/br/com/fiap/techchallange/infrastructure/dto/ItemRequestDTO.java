package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class ItemRequestDTO implements Serializable {
    @Schema(name = "sku", example = "123456A", required = true)
    private String sku;
    @Schema(name = "amount", example = "35.00", required = true)
    private float amount;
    @Schema(name = "quantity", example = "1", required = true)
    private Integer quantity;

    public ItemRequestDTO(String sku, float amount, Integer quantity) {
        this.sku = sku;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String sku() {
        return sku;
    }

    public float amount() {
        return amount;
    }

    public Integer quantity() {
        return quantity;
    }
}