package br.com.fiap.techchallange.core.entity.enums;

public enum MethodPayment{
    QRCODE("QRCode"), PIX("Pix"), CARD("Card");

    private final String value;

    MethodPayment(String valueMethod){
        value = valueMethod;
    }

    public String getValue(){
        return value;
    }

    public static MethodPayment fromValue(String value) {
        for (MethodPayment status : MethodPayment.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
