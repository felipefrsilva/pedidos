package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryOrderRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MySQLOrderRepository;

public class FactoryOrderRepository{

    public static IOrderRepository create(){
        int num = 1;
        IOrderRepository repository = null;

        switch (num) {
            case 1:
                repository = MemoryOrderRepository.getInstance();
                    break;
            case 2:
                repository = SpringContext.getBean(MySQLOrderRepository.class);
                break;
            default:
                System.out.println("Database not configuraded");
        }

        return repository;
    }
}
