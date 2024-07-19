package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.infrastructure.bd.mock.MemoryOrderRepository;
import br.com.fiap.techchallange.infrastructure.bd.MySQLOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FactoryOrderRepository{

    private final ApplicationContext applicationContext;

    @Autowired
    public FactoryOrderRepository(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public IOrderRepository create(){
        int num = 2;
        IOrderRepository repository = null;

        switch (num) {
            case 1:
                repository = MemoryOrderRepository.getInstance();
                    break;
            case 2:
                repository = applicationContext.getBean(MySQLOrderRepository.class);
                break;
            default:
                System.out.println("Database not configuraded");
        }

        return repository;
    }

}
