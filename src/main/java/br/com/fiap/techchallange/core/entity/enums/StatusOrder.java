package br.com.fiap.techchallange.core.entity.enums;

public enum StatusOrder {
    OPEN("Aberto"), RECEIVED("Recebido"), INPREPARATION("Em Preparação"), FINISHED("Finalizado"), FOODDONE("COMIDA PRONTA");

    private final String value;

    StatusOrder(String valueStatus){
        value = valueStatus;
    }

    public String getValue(){
        return value;
    }

    public static StatusOrder fromValue(String value) {
        for (StatusOrder status : StatusOrder.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
