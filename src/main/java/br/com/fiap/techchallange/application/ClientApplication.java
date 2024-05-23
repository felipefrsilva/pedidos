package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.factory.FactoryClientRepository;
import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.domain.entity.Client;

public class ClientApplication {
    IClientRepository repository;

    public ClientApplication() {
        this.repository = FactoryClientRepository.create();
    }

    public void addCLient(String cpf, String name, String email) {
        this.repository.addClient(cpf, name, email);
    }

    public Client getClient(String cpf) {
        return this.repository.getClient(cpf);
    }

//    public List<Client> getClients() {
//        return this.repository.getClients();
//    }

}
