package br.com.fiap.techchallange.core.entity;

import br.com.fiap.techchallange.core.entity.vo.CPF;
import br.com.fiap.techchallange.core.entity.vo.Email;
import br.com.fiap.techchallange.core.entity.vo.Name;

public class Customer {
    public CPF cpf;
    private final Name name;
    private final Email email;

    public Customer(String cpf, String name, String email) throws IllegalArgumentException {
        this.cpf = new CPF(cpf);
        this.name = new Name(name);
        this.email = new Email(email);
    }

    public String getCPF() {
        return cpf.getCpfValue();
    }

    public String getName() {
        return name.getNameValue();
    }

    public String getEmail() {
        return email.getEmailValue();
    }
}
