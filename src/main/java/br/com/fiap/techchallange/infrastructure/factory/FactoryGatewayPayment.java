package br.com.fiap.techchallange.infrastructure.factory;

import br.com.fiap.techchallange.adapters.gateways.service.IGatewayPayment;
import br.com.fiap.techchallange.infrastructure.service.GatewayPaymentMock;
import org.springframework.stereotype.Component;

@Component
public class FactoryGatewayPayment {

    public static IGatewayPayment create(){
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
}
