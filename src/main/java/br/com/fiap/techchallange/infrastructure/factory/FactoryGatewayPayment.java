package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.infrastructure.service.PaymentGatewayMock;
import org.springframework.stereotype.Component;

@Component
public class FactoryGatewayPayment {

    public static IPaymentGateway create(){
        int num = 1;
        IPaymentGateway gatewayPayment = null;

        switch (num) {
            case 1:
                gatewayPayment = new PaymentGatewayMock();
                break;
            default:
                System.out.println("Database not configuraded");
        }

        return gatewayPayment;
    }
}
