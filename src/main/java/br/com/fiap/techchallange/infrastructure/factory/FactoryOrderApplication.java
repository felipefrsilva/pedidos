package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.application.usecases.ServiceOrderApplication;
import br.com.fiap.techchallange.application.ports.out.api.IGatewayPayment;
import br.com.fiap.techchallange.application.ports.out.api.IGenerateNumberOrder;
import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.http.GatewayPaymentMock;
import br.com.fiap.techchallange.infrastructure.adapters.out.http.GenerateNumberOrderMock;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryOrderRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryProductRepository;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MySQLOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class FactoryOrderApplication {

    private final ApplicationContext applicationContext;

    @Autowired
    public FactoryOrderApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ServiceOrderApplication createOrderApplication(){
        return new ServiceOrderApplication(this.getOrderRepository(),
                                    this.getProductRepository(),
                                    this.getGatewayPayment(),
                                    this.getGenerateNumberOrder());
    }

    private IGenerateNumberOrder getGenerateNumberOrder() {
        int num = 1;
        IGenerateNumberOrder generateNumberOrder = null;

        switch (num) {
            case 1:
                generateNumberOrder = new GenerateNumberOrderMock();
                break;
            default:
                System.out.println("Database not configuraded");
        }

        return generateNumberOrder;
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

    private IGatewayPayment getGatewayPayment(){
        int num = 1;
        IGatewayPayment gatewayPayment = null;

        switch (num) {
            case 1:
                gatewayPayment = new GatewayPaymentMock();
                break;
            default:
                System.out.println("Database not configuraded");
        }

        return gatewayPayment;
    }

    private IProductRepository getProductRepository(){
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
