package br.com.fiap.techchallange.orders.domain.entity;

import br.com.fiap.techchallange.orders.domain.vo.CPF;
import lombok.Getter;

public class Client {
    public CPF cpf;
    @Getter
    private String name;
    private String email;

    public Client(CPF cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public String getCpfVo() {
        return cpf.getCpfValue();
    }

    public String getEmail() {
        return email;
    }
}
