package br.com.fiap.techchallange.orders.domain.entity;

import br.com.fiap.techchallange.orders.domain.vo.CPFVo;

public class Client {
    public CPFVo cpfVo;
    private String name;
    private String email;

    public Client(CPFVo cpf, String name, String email) {
        this.cpfVo = cpf;
        this.name = name;
        this.email = email;
    }

    public CPFVo getCpfVo() {
        return cpfVo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
