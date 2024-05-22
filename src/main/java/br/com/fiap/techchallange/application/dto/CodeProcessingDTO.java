package br.com.fiap.techchallange.application.dto;

public class CodeProcessingDTO {
    private String idOrder;
    private String code;

    public CodeProcessingDTO(String idOrder, String code) {
        this.setIdOrder(idOrder);
        this.setCode(code);
    }

    public String getIdOrder() {
        return idOrder;
    }

    public String getCode() {
        return code;
    }

    private void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    private void setCode(String code) {
        this.code = code;
    }
}
