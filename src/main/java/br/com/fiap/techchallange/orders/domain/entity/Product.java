package br.com.fiap.techchallange.orders.domain.entity;

import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;
import lombok.Getter;

public class Product {
    @Getter
    String sku;
    @Getter
    String name;
    @Getter
    String description;
    MonetaryValue monetaryValue;
    @Getter
    String category;

    // TODO: Add image property
    public Product(String sku, String name, String description, MonetaryValue monetaryValue, String category) {
        this.setSku(sku);
        this.setName(name);
        this.setDescription(description);
        this.setMonetaryValue(monetaryValue);
        this.setCategory(category);
    }

    private void setSku(String sku) {
        checkValue(sku, "sku");
        this.sku = sku;
    }

    private void setName(String name) {
        checkValue(name, "name");
        this.name = name;
    }

    private void setDescription(String description) {
        checkValue(description, "description");
        this.description = description;
    }

    public float getMonetaryValue() {
        return monetaryValue.getValue();
    }

    private void setMonetaryValue(MonetaryValue monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    private void setCategory(String category) {
        checkValue(category, "category");
        this.category = category;
    }

    private void checkValue(String string, String nameVariable){
        if(string == null || string == "")
            throw new IllegalArgumentException(
                    nameVariable + " cannot be empty"
            );
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", monetaryValue=" + monetaryValue.getValue() +
                ", category='" + category + '\'' +
                '}';
    }
}
