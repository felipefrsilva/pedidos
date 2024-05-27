package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
//import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryClientRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MySQLClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FactoryClientApplication {

    private final ApplicationContext applicationContext;

    @Autowired
    public FactoryClientApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ClientApplication createClientApplication(){
        return new ClientApplication(this.getClientRepository());
    }

    private IClientRepository getClientRepository(){
        int num = 2;
        IClientRepository repository = null;

        switch (num) {
            case 1:
                // repository = MemoryClientRepository.getInstance();
                break;
            case 2:
                repository = applicationContext.getBean(MySQLClientRepository.class);
                break;
            default:
                System.out.println("Database not configuraded");
        }

        return repository;
    }
}
