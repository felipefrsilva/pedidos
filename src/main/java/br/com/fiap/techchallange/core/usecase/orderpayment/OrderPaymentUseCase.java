package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.dto.ordercreation.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IOrderPaymentUseCase;

import java.io.IOException;

public class OrderPaymentUseCase implements IOrderPaymentUseCase {
    IOrderRepository repositoryOrder;
    IPaymentGateway gatewayPayment;

    public OrderPaymentUseCase(IOrderRepository repositoryOrder, IPaymentGateway gatewayPayment) {
        this.repositoryOrder = repositoryOrder;
        this.gatewayPayment = gatewayPayment;
    }

    public OutputDataPaymentDTO initializePayment(InputDataOrderDTO inputDataOrderDTO) throws IOException {
        // TODO: Considerar outros métodos de pagamento, cartão, dinheiro, etc.
        Order order = repositoryOrder.get(inputDataOrderDTO.getId());
        // TODO: Trocar para Payment
        Payment payment = gatewayPayment.initializePayment(order.getId(), order.getAmount());
        order.addReadingCodePayment(payment.getReadingCode());
        repositoryOrder.updatePayment(order);
        OutputDataPaymentDTO outputDataPaymentDTO = new OutputDataPaymentDTO(payment);
        return outputDataPaymentDTO;
    }
}
