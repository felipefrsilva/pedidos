package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class addOrderDTO implements Serializable {

    @Schema(name = "idOrder", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String idOrder;
    @Schema(name = "sku", example = "123456C", required = true)
    private String sku;
    @Schema(name = "qtd", example = "3", required = true)
    private Integer qtd;

    public addOrderDTO() {}

    public addOrderDTO(String idOrder, String sku, Integer qtd) {
        this.setIdOrder(idOrder);
        this.setSku(sku);
        this.setQtd(qtd);
    }

    public String getIdOrder() {
        return idOrder;
    }

    private void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getSku() { return sku; }

    public Integer getQtd() { return qtd;  }

    private void setSku(String sku) { this.sku = sku; }

    private void setQtd(Integer qtd) { this.qtd = qtd; }
}
