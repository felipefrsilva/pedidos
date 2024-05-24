package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.application.dto.ClientDTO;
import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.domain.entity.Client;

public class ClientApplication {
    IClientRepository repository;

    public ClientApplication(IClientRepository repository) {
        this.repository = repository;
    }

    public void addCLient(String cpf, String name, String email) {
        this.repository.addClient(cpf, name, email);
    }

    public ClientDTO getClient(String cpf) {
        // Get Client from DataBase
        Client client = this.repository.getClient(cpf);

        // Build Client DTO to return
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setCpf(client.getCPF());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());

        return clientDTO;
    }

}
