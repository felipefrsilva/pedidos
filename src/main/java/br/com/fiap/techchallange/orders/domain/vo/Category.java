package br.com.fiap.techchallange.orders.domain.vo;

public enum Category {
    Snack("Lanche"), Drink("Bebida"), Dessert("Sobremesa");

    private final String value;

    Category(String valueCategory){
        value = valueCategory;
    }

    public String getValue(){
        return value;
    }
}
