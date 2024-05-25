package br.com.fiap.techchallange.domain.enums;

public enum Category {
    Meal("Meal"), Sides("Sides"), Drink("Dink"), Dessert("Dessert");

    private final String value;

    Category(String valueCategory){
        value = valueCategory;
    }

    public String getValue(){
        return value;
    }
}
