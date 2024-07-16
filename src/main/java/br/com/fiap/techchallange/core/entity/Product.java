package br.com.fiap.techchallange.core.entity;

import br.com.fiap.techchallange.core.entity.enums.Category;
import br.com.fiap.techchallange.core.entity.vo.MonetaryValue;

import java.io.Serializable;
import java.math.BigDecimal;


public class Product implements Serializable {

    String sku;
    String name;
    String description;
    MonetaryValue monetaryValue;
    Category category;

    public Product(String sku, String name, String description, Float monetaryValue, String category) {
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

    private void setMonetaryValue(float monetaryValue) {
        this.monetaryValue = new MonetaryValue(new BigDecimal(monetaryValue));
    }

    private void setCategory(String category) {
        checkValue(category, "category");
        Category.fromValue(category);
        this.category = Category.fromValue(category);
    }

    private void checkValue(String string, String nameVariable){
        if(string == null || string.isEmpty())
            throw new IllegalArgumentException(
                    nameVariable + " cannot be empty"
            );
    }

    public float getMonetaryValue() {
        return monetaryValue.getValue();
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category.getValue();
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
