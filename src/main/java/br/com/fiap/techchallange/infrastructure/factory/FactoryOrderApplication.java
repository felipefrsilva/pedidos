package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.core.usecase.ServiceOrderApplication;
import br.com.fiap.techchallange.adapters.gateways.service.IGatewayPayment;
import br.com.fiap.techchallange.adapters.gateways.service.IGenerateNumberOrder;
import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.service.GatewayPaymentMock;
import br.com.fiap.techchallange.infrastructure.service.GenerateNumberOrderMock;
import br.com.fiap.techchallange.infrastructure.bd.mock.MemoryOrderRepository;
import br.com.fiap.techchallange.infrastructure.bd.mock.MemoryProductRepository;
import br.com.fiap.techchallange.infrastructure.bd.MySQLOrderRepository;
import br.com.fiap.techchallange.infrastructure.bd.MySQLProductRepository;
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

                System.out.println("Database not configuraded");
        }

        return repository;
    }

}
