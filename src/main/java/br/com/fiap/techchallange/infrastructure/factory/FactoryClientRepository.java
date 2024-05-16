package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.infrastructure.adapters.out.MemoryClientRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IClientRepository;

public class FactoryClientRepository {
    public static IClientRepository create() {
        int num = 1;

        IClientRepository repository = null;

        switch (num) {
            case 1:
                repository = new MemoryClientRepository();
                break;
        }

        return repository;
    }
}
