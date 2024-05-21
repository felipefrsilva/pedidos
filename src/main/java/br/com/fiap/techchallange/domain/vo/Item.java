package br.com.fiap.techchallange.domain.vo;

import br.com.fiap.techchallange.domain.entity.Product;

public class Item {

    Product product;
    Integer quantity;
    float amount;

    public Item(Product product, Integer quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setAmount();
    }

    public String getSKU(){
        return product.getSku();
    }

    public String getProduct() {
        return product.getName();
    }

    private void setProduct(Product product) {
        if(product == null) {
            throw new IllegalArgumentException("Product not be null");
        }

        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    private void setQuantity(Integer quantity) {
        if(quantity <= 0){
            throw new IllegalArgumentException(
                    "quantity of item cannot be less than or equal to zero"
            );
        }
            this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    private void setAmount() {
        this.amount = product.getMonetaryValue() * this.quantity ;
    }
}
