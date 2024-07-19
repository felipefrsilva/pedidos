package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentUpdateOrderUseCase;

import java.io.IOException;

public class PaymentUpdateOrderUseCase implements IPaymentUpdateOrderUseCase {
    IOrderRepository repositoryOrder;
    IPaymentGateway gatewayPayment;

    public PaymentUpdateOrderUseCase(IOrderRepository repositoryOrder, IPaymentGateway gatewayPayment) {
        this.repositoryOrder = repositoryOrder;
        this.gatewayPayment = gatewayPayment;
    }

    @Override
    public void updateOrderPayment(String idOrder) throws IOException {
        Order order = repositoryOrder.get(idOrder);
        Payment payment = gatewayPayment.getPayment(idOrder);
        order.setPayment(payment);
        repositoryOrder.updatePayment(order);
    }
}
