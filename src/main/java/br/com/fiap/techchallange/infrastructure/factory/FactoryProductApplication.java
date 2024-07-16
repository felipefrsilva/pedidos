package br.com.fiap.techchallange.infrastructure.factory;


import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.bd.MySQLProductRepository;
import br.com.fiap.techchallange.core.usecase.ProductApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FactoryProductApplication {
    private final ApplicationContext applicationContext;

    @Autowired
    public FactoryProductApplication(ApplicationContext applicationContext) {
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
                // Manually retrieving the bean for Spring's autowiring
                repository = applicationContext.getBean(MySQLProductRepository.class);
                break;
            default:
                System.out.println("Database not configured");
        }
        return repository;
    }
}
