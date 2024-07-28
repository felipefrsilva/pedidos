package br.com.fiap.techchallange.core.entity.enums;

public enum Category {
    Meal("Lanche"), Sides("Acompanhamento"), Drink("Bebida"), Dessert("Sobremesa");

    private final String value;

    Category(String valueCategory){
        value = valueCategory;
    }

    public String getValue(){
        return value;
    }

    public static Category fromValue(String value) {
        for (Category status : Category.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido para campo de Category: " + value + "Esperado: " +
                Meal.getValue() + " " + Sides.getValue() + " " + Drink.getValue() + " " + Dessert.getValue());
    }
}
