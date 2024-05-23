package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryProductRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MySQLOrderRepository;
import org.springframework.stereotype.Component;

@Component
public class FactoryProductRepository {

    public FactoryProductRepository(){

    }

    public static IProductRepository create(){
        int num = 1;
        IProductRepository repository = null;

        switch (num) {
            case 1:
                repository = new MemoryProductRepository();
                break;
            default:

                System.out.println("Database not configuraded");
        }

        return repository;
    }
}
