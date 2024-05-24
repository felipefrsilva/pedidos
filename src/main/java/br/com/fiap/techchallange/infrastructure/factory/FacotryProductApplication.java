package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MySQLProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FacotryProductApplication {
    private final ApplicationContext applicationContext;

    @Autowired
    public FacotryProductApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ProductApplication createProductApplication() {
        return new ProductApplication(this.getProductRepository());
    }

    private IProductRepository getProductRepository() {
        int num = 2;
        IProductRepository repository = null;

        switch (num) {
            case 1:
                break;
            case 2:
                repository = applicationContext.getBean(MySQLProductRepository.class);
                break;
            default:
                System.out.println("Database not configurated");
        }
        return repository;
    }
}
