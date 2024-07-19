package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentInitializeUseCase;

import java.io.IOException;

public class PaymentInitializeUseCase implements IPaymentInitializeUseCase {
    IOrderRepository repositoryOrder;
    IPaymentGateway gatewayPayment;

    public PaymentInitializeUseCase(IOrderRepository repositoryOrder, IPaymentGateway gatewayPayment) {
        this.repositoryOrder = repositoryOrder;
        this.gatewayPayment = gatewayPayment;
    }

    @Override
    public void initializePayment(String idOrder) throws IOException {
        Order order = repositoryOrder.get(idOrder);
        gatewayPayment.initializePayment(order.getId(), order.getAmount());
        PaymentUpdateOrderUseCase updateOrderUseCase = new PaymentUpdateOrderUseCase(
                this.repositoryOrder, this.gatewayPayment
        );
        updateOrderUseCase.updateOrderPayment(idOrder);
    }
}
