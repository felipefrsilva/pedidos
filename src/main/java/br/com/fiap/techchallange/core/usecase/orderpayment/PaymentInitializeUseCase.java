package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentQRCodeGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentInitializeUseCase;

import java.io.IOException;

public class PaymentInitializeUseCase implements IPaymentInitializeUseCase {
    IOrderRepository repositoryOrder;
    IPaymentQRCodeGateway gatewayPayment;

    public PaymentInitializeUseCase(IOrderRepository repositoryOrder, IPaymentQRCodeGateway gatewayPayment) {
        this.repositoryOrder = repositoryOrder;
        this.gatewayPayment = gatewayPayment;
    }

    @Override
    public void initializePayment(String idOrder) throws IOException {
        Order order = repositoryOrder.get(idOrder);
        String qr_code = gatewayPayment.initializePayment(order.getId(), order.getAmount());
        order.addReadingCodePayment(qr_code);
        repositoryOrder.updatePayment(order);
    }
}
