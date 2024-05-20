package br.com.fiap.techchallange.domain.enums;

public enum GatewayPayment {
    MERCADOPAGO("MercadoPago"), CIELO("Cielo"), PAGSEGURO("PagSeguro");

    private final String value;

    GatewayPayment(String valueGateway){
        value = valueGateway;
    }

    public String getValue(){
        return value;
    }
}
