package br.com.fiap.techchallange.core.usecase.dto.customer;

public record OutputDataCustomerDTO(String cpf, String name, String email) {

    public OutputDataCustomerDTO{
        cpf = formatCpf(cpf);
    }

    public String formatCpf(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
