package br.com.fiap.techchallange.domain.enums;

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
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
