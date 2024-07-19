package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.bd.mock.MemoryProductRepository;
import br.com.fiap.techchallange.infrastructure.bd.MySQLProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FactoryProductRepository {
    // This component allows communication between adapters within the Application Service
    private final ApplicationContext applicationContext;

    @Autowired
    public FactoryProductRepository(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public IProductRepository create(){
        int num = 2;
        IProductRepository repository = null;

        switch (num) {
            case 1:
                repository = new MemoryProductRepository();
                break;
            case 2:
                // Manually retrieving the bean for Spring's autowiring
                repository = applicationContext.getBean(MySQLProductRepository.class);
                break;
            default:
                System.out.println("Database not configured");
        }

        return repository;
    }
}
