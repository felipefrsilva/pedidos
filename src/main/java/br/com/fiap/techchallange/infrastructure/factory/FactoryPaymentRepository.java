package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.bd.mock.MemoryProductRepository;

public class FactoryPaymentRepository {

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
