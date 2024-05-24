package br.com.fiap.techchallange.domain.entity;

import br.com.fiap.techchallange.domain.vo.CPF;

public class Client {
    public CPF cpf;
    private String name;
    private String email;

    public Client(CPF cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getCPF() {
        return cpf.getCpfValue();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
