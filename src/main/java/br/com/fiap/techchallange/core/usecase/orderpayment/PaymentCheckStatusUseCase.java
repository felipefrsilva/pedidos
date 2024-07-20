package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentQRCodeGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentCheckStatusUseCase;

import java.io.IOException;

public class PaymentCheckStatusUseCase implements IPaymentCheckStatusUseCase {
    IOrderRepository orderRepository;

    public PaymentCheckStatusUseCase(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String checkPaymentStatus(String idOrder) throws IOException {
        Order order = this.orderRepository.get(idOrder);
        Payment payment = order.getPayment();
        return payment.getStatus();
    }
}
