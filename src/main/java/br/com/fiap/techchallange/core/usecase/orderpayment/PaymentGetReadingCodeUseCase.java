package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentQRCodeGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentGetReadingCodeUseCase;

import java.io.IOException;

public class PaymentGetReadingCodeUseCase implements IPaymentGetReadingCodeUseCase {
    IOrderRepository orderRepository;

    public PaymentGetReadingCodeUseCase(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String getReadingCode(String idOrder) throws IOException {
        Order order = this.orderRepository.get(idOrder);
        return order.getCodeReadingPayment();
    }
}
