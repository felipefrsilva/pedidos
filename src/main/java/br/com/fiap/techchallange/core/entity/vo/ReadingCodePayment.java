package br.com.fiap.techchallange.core.entity.vo;

import java.io.Serializable;

public class ReadingCodePayment implements Serializable {

    private String code;

    public ReadingCodePayment(String code) {
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {

        if (code == null){
            throw new IllegalArgumentException(
                    "Processing Code Reading cannot be empty"
            );
        }

        this.code = code;
    }
}
