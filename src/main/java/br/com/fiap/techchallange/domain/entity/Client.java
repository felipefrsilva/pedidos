package br.com.fiap.techchallange.domain.entity;

import br.com.fiap.techchallange.domain.vo.CPF;
import br.com.fiap.techchallange.domain.vo.Email;
import br.com.fiap.techchallange.domain.vo.FullName;

public class Client {

    private CPF cpf;
    private FullName fullName;
    private Email email;

    public Client(String cpf, String name, String email) {
        this.setCpf(cpf);
        this.setName(name);
        this.setEmail(email);
    }

    private void alterCPF(String cpf){
        this.cpf = new CPF(cpf);
    }

    public String getCpf() {
        return cpf.getNumber();
    }

    public String getFullName() {
        return fullName.getFullName();
    }

    public String getEmail() {
        return email.getEmail();
    }

    private void setCpf(String cpf) {


        this.cpf = new CPF(cpf);
    }

    private void setName(String name) {
        this.fullName = new FullName(name);
    }

    private void setEmail(String email) {
        this.email = new Email(email);
    }
}
