package br.com.fiap.techchallange.orders.domain.entity;

import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;

public class Product {
    String sku;
    String name;
    String description;
    MonetaryValue monetaryValue;
    String category;

    public Product(String sku, String name, String description, MonetaryValue monetaryValue, String category) {
        this.setSku(sku);
        this.setName(name);
        this.setDescription(description);
        this.setMonetaryValue(monetaryValue);
        this.setCategory(category);
    }

    public String getSku() {
        return sku;
    }

    private void setSku(String sku) {
        checkValue(sku, "sku");
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        checkValue(name, "name");
        this.name = name;
    }

    public String getDescription() {
        return description;
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

    public String getCategory() {
        return this.category;
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

}
