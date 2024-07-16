package br.com.fiap.techchallange.core.entity.vo;

import java.io.Serializable;

public class Email implements Serializable {

    private String emailValue;

    public Email(String email) {
        this.checkEmailValue(email);
    }

    public void checkEmailValue(String email) throws IllegalArgumentException {
        if (email.startsWith("@") || !email.contains("@") || !email.endsWith(".com")) {
            throw new IllegalArgumentException("Email é inválido!");
        }
        this.emailValue = email;
    }

    public String getEmailValue() {
        return emailValue;
    }
}
