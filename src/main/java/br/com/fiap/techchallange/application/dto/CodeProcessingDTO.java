package br.com.fiap.techchallange.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

public class CodeProcessingDTO implements Serializable {

    @Schema(name = "idOrder", example = "defa318d-d6e4-4184-8c15-9c50c446584f", required = true)
    private String idOrder;
    @Schema(name = "code", example = "VMQ4DIQwETXXP4KcIfsozqEK8NiTRhavZgtUJGQ/FCtuc9C", required = true)
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
