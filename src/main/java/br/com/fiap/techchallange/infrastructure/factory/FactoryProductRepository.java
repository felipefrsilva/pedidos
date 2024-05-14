package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.infrastructure.adapters.out.MemoryProductRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;

public class FactoryProductRepository {

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
