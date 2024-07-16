package br.com.fiap.techchallange.core.entity.vo;

import java.io.Serializable;

public class ProcessingCodePayment implements Serializable {

    private String code;

    public ProcessingCodePayment(String code) {
        this.setCode(code);
    }

    private void setCode(String code) {

        if (code == null){
            throw new IllegalArgumentException(
                    "Processing Code Payment cannot be empty"
            );
        }

        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
