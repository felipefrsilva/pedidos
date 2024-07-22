package br.com.fiap.techchallange.core.entity.enums;

public enum StatusPayment {
    OPEN("OPEN"), PROCESSING("PROCESSING"), PAID("PAID"), PAYMENT_DENIED("PAYMENT_DENIED");

    private final String value;

    StatusPayment(String valueStatus){
        value = valueStatus;
    }

    public String getValue(){
        return value;
    }

    public static StatusPayment fromValue(String value) {
        for (StatusPayment status : StatusPayment.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
