package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.application.dto.ClientDTO;

public interface ClientManagement {
        public void addClient(String cpf, String name, String email);
        public ClientDTO getClient(String cpf);
}
