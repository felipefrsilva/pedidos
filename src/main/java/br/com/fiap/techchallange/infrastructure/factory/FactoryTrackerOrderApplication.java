package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.application.usecases.TrackerOrderApplication;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryOrderRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MySQLOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FactoryTrackerOrderApplication {

    private final ApplicationContext applicationContext;

    @Autowired
    public FactoryTrackerOrderApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public TrackerOrderApplication createTrackerOrder(){
        return new TrackerOrderApplication(this.getOrderRepository());
    }

    private IOrderRepository getOrderRepository(){
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
