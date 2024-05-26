package br.com.fiap.techchallange.domain.vo;

import java.io.Serializable;

public class CPF implements Serializable {

    public String number;

    public CPF(String number) {
        this.setNumber(number);
    }

    private void setNumber(String number) {

        if(number == null)
            throw new IllegalArgumentException(
                    "CPF cannot be empty"
            );

        // Incluir a lógica para validar se o CPF é Valido

        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
