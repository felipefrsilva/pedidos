package br.com.fiap.techchallange.core.usecase.dto.managementcustomer;

public class OutputDataCustomerDTO {
    private String cpf, name, email;

    public OutputDataCustomerDTO(String cpf, String name, String email){
        setCpf(cpf);
        setEmail(email);
        setName(name);
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }
}
