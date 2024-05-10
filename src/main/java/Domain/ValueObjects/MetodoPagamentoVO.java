package Domain.ValueObjects;

public class MetodoPagamentoVO {
    private String metodo;
    private String gateway;
    private String codigo;

    public String getMetodo() {
        return metodo;
    }

    public String getGateway() {
        return gateway;
    }

    public String getCodigo() {
        return codigo;
    }
}
