package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class removeOrderDTO implements Serializable {

    @Schema(name = "idOrder", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String idOrder;
    @Schema(name = "sku", example = "123456C", required = true)
    private String sku;

    public removeOrderDTO() {}

    public removeOrderDTO(String idOrder, String sku, Integer qtd) {
        this.setIdOrder(idOrder);
        this.setSku(sku);
    }

    public String getIdOrder() {
        return idOrder;
    }

    private void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getSku() { return sku; }

    private void setSku(String sku) { this.sku = sku; }
}
