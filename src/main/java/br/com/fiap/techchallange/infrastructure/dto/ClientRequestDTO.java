package br.com.fiap.techchallange.infrastructure.dto;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public record ClientRequestDTO (String cpf, String name, String email){

    public ClientRequestDTO(
            @JsonProperty("cpf") String cpf,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email
    ) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public ClientRequestDTO(@NotNull InputDataCustomerDTO customerDTO) {
        this(customerDTO.getCpf(), customerDTO.getName(), customerDTO.getEmail());
    }
}
