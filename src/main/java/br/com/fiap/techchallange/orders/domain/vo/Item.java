package br.com.fiap.techchallange.orders.domain.vo;

import br.com.fiap.techchallange.orders.domain.entity.Product;

public class Item {

    Product product;
    Integer quantity;
    float amount;

    public Item(Product product, Integer quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
        this.setAmount();
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        checkValue(product, "product");
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
        this.amount = product.getMonetaryValue() * quantity ;
    }

    private void checkValue(Object object, String nameVariable){
        if(object == null)
            throw new IllegalArgumentException(
                    nameVariable + " not be null"
            );
    }

}
