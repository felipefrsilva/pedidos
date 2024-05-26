package br.com.fiap.techchallange.application.dto;

import java.io.Serializable;

public class ItemDTO implements Serializable {

    private String sku;
    private float amount;
    private Integer qtd;

    public ItemDTO(){}

    public ItemDTO(String sku, float amount, Integer qtd) {
        this.setSku(sku);
        this.setAmount(amount);
        this.setQtd(qtd);
    }

    public ItemDTO(String sku, Integer qtd) {
        this.setSku(sku);
        this.setQtd(qtd);
    }

    public String getSku() {
        return sku;
    }

    public float getAmount() {
        return amount;
    }

    public Integer getQtd() {
        return qtd;
    }

    private void setSku(String sku) {
        this.sku = sku;
    }

    private void setAmount(float amount) {
        this.amount = amount;
    }

    private void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
