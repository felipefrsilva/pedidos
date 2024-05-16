package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.factory.FactoryClientRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IClientRepository;

public class ClientApplication {
    IClientRepository repository;

    public ClientApplication() {
        this.repository = FactoryClientRepository.create();
    }
}
