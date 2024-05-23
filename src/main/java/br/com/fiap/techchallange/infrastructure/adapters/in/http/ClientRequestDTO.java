package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.domain.entity.Client;
import br.com.fiap.techchallange.orders.domain.entity.Product;
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

    public ClientRequestDTO(@NotNull Client client) {
        this(client.getCpfVo(), client.getName(), client.getEmail());
    }
}
