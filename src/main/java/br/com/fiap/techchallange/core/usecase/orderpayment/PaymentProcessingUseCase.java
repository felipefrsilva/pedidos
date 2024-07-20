package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentProcessingUseCase;

import java.io.IOException;

public class PaymentProcessingUseCase implements IPaymentProcessingUseCase {
    IOrderRepository repositoryOrder;

    public PaymentProcessingUseCase(IOrderRepository repositoryOrder) {
        this.repositoryOrder = repositoryOrder;
    }

    @Override
    public void processPayment(String idOrder, String processingCode, StatusPayment statusPayment) throws IOException {
        Order order = repositoryOrder.get(idOrder);
        order.processingPayment(processingCode, statusPayment);
        repositoryOrder.update(order);
        repositoryOrder.updatePayment(order);
    }
}
