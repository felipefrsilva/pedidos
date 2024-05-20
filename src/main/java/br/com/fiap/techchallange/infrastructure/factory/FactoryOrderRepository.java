package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryOrderRepository;

public class FactoryOrderRepository {

    public static IOrderRepository create(){
        int num = 1;
        IOrderRepository repository = null;

        switch (num) {
            case 1:
                repository = MemoryOrderRepository.getInstance();
                    break;
            default:
                System.out.println("Database not configuraded");
        }

        return repository;
    }
}
