package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.factory.FactoryClientRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.orders.domain.entity.Client;

public class ClientApplication {
    IClientRepository repository;

    public ClientApplication() {
        this.repository = FactoryClientRepository.create();
    }

    public Client addCLient(String cpf, String name, String email) {
        return this.repository.addClient(cpf, name, email);
    }

}
