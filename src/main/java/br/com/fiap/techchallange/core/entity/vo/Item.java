package br.com.fiap.techchallange.core.entity.vo;

import br.com.fiap.techchallange.core.entity.Product;

import java.io.Serializable;

public class Item implements Serializable {

    String order_id;
    String sku;
    Integer quantity;
    float unitValue;
    float amount;

    public Item(String order_id, String sku, Integer quantity, float unitValue) {

        this.order_id = order_id;
        this.sku = sku;
        this.unitValue = unitValue;
        this.setQuantity(quantity);
        this.setAmount();
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getSku() {
        return sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public float getUnitValue(){
        return this.unitValue;
    }

    private void setQuantity(Integer quantity) {
        if(quantity <= 0){
            throw new IllegalArgumentException(
                    "quantity of item cannot be less than or equal to zero"
            );
        }
            this.quantity = quantity;
    }

    private void setSKU(String sku){
        this.sku = sku;
    }

    public float getAmount() {
        return amount;
    }

    private void setAmount() {
        this.amount = this.unitValue * this.quantity ;
    }

}
