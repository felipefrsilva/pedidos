package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentQRCodeGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IGetOrderPaymentUseCase;

import java.io.IOException;

public class GetOrderPaymentUseCase implements IGetOrderPaymentUseCase {
    IOrderRepository orderRepository;

    public GetOrderPaymentUseCase(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OutputDataPaymentDTO getOrderPayment(String idOrder) throws IOException {
        Order order = orderRepository.get(idOrder);
        Payment payment = order.getPayment();
        return new OutputDataPaymentDTO(payment);
    }
}
