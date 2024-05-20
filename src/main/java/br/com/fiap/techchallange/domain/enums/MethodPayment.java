package br.com.fiap.techchallange.domain.enums;

public enum MethodPayment{
    QRCODE("QRCode"), PIX("Pix"), CARD("Card");

    private final String value;

    MethodPayment(String valueMethod){
        value = valueMethod;
    }

    public String getValue(){
        return value;
    }
}
