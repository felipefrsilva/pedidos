package br.com.fiap.techchallange.orders.domain.vo;

public enum StatusOrder {
    OPEN("Aberto"), RECEIVED("Recebido"), INPREPARATION("Em Preparação"), READY("Pronto"), FINISHED("Finalizado");

    private final String value;

    StatusOrder(String valueStatus){
        value = valueStatus;
    }

    public String getValue(){
        return value;
    }
}
