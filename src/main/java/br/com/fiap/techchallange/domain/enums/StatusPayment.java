package br.com.fiap.techchallange.domain.enums;

public enum StatusPayment {
    OPEN("Aberto"), PAID("Pago"), PAYMENTDENIED("Pagamento Negado");

    private final String value;

    StatusPayment(String valueStatus){
        value = valueStatus;
    }

    public String getValue(){
        return value;
    }
}
