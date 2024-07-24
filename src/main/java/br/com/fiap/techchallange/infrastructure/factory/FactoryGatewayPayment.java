//package br.com.fiap.techchallange.infrastructure.factory;
//
//import br.com.fiap.techchallange.adapters.gateways.service.IPaymentQRCodeGateway;
//import br.com.fiap.techchallange.infrastructure.service.PaymentQRCodeGatewayMock;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FactoryGatewayPayment {
//
//    public static IPaymentQRCodeGateway create(){
//        int num = 1;
//        IPaymentQRCodeGateway gatewayPayment = null;
//
//        switch (num) {
//            case 1:
//                gatewayPayment = new PaymentQRCodeGatewayMock();
//                break;
//            default:
//                System.out.println("Database not configuraded");
//        }
//
//        return gatewayPayment;
//    }
//}
