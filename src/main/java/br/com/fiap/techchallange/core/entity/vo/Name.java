package br.com.fiap.techchallange.core.entity.vo;

import java.util.InputMismatchException;

public class Name {
    private String nameValue;

    public Name(String name) {
        this.checkNameValue(name);
    }

    public void checkNameValue(String name) throws InputMismatchException {
//        if (name.matches(".*\\d.*")) {
//            name = null;
//        }

        for (char c : name.toCharArray()) {
            if (Character.isDigit(c) || ((!Character.isLetter(c) && c != ' '))){
                name = null;
            }
        }

        if (name == null) {
            throw new IllegalArgumentException("Nome é inválido!");
        } else {
            this.nameValue = name;
        }
    }

    public String getNameValue() {
        return this.nameValue;
    }
}
