package br.com.fiap.techchallange.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class CodeProcessingDTO implements Serializable {

    @Schema(name = "idOrder", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String idOrder;
    @Schema(name = "code", example = "VMQ4DIQwETXXP4KcIfsozqEK8NiTRhavZgtUJGQ/FCtuc9C", required = true)
    private String code;
    @Schema(name = "statusPayment", example="PAID", required=true)
    private String statusPayment;

    public CodeProcessingDTO(String idOrder, String code, String statusPayment) {
        this.setIdOrder(idOrder);
        this.setCode(code);
        this.setStatusPayment(statusPayment);
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

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }
}
