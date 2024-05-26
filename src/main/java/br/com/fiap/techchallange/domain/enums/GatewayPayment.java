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

    public static GatewayPayment fromValue(String value) {
        for (GatewayPayment status : GatewayPayment.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + value);
    }
}
