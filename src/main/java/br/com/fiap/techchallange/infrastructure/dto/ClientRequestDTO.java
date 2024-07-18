package br.com.fiap.techchallange.infrastructure.dto;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
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
        this(customerDTO.cpf(), customerDTO.name(), customerDTO.email());
    }
}
