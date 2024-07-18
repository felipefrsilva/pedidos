package br.com.fiap.techchallange.core.usecase.dto.customer;

public record InputDataCustomerDTO(String cpf, String name, String email) {

    public InputDataCustomerDTO {
        cpf = formatCpf(cpf);
    }

    private static String formatCpf(String cpf) {
        return  cpf.replaceAll("[.-]", "");
    }

    public InputDataCustomerDTO(String cpf){
        this(cpf, "","");
    }
}