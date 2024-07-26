package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.service.IGenerateNumberOrder;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;
import br.com.fiap.techchallange.core.usecase.dto.order.EventOrder;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentProcessingUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IEventTrigger;

import java.io.IOException;

public class PaymentProcessingUseCase implements IPaymentProcessingUseCase {
    private final IOrderRepository repositoryOrder;
    private final IEventTrigger trigger;
    private final IGenerateNumberOrder generateNumberOrder;

    public PaymentProcessingUseCase(IOrderRepository repositoryOrder, IEventTrigger trigger, IGenerateNumberOrder generateNumberOrder) {
        this.repositoryOrder = repositoryOrder;
        this.trigger = trigger;
        this.generateNumberOrder = generateNumberOrder;
    }

    @Override
    public void processPayment(String idOrder, String processingCode, StatusPayment statusPayment) throws IOException {
        Order order = repositoryOrder.get(idOrder);
        order.setNumberOrder(generateNumberOrder.generate());
        order.processingPayment(processingCode, statusPayment);
        repositoryOrder.update(order);
        repositoryOrder.updatePayment(order);
        // order.getNumberOrder() é atualizado antes do evento ser disparado
        this.trigger.event(new EventOrder(
                order.getNumberOrder(),
                EventOrder.TypeEventOrder.PAYMENT.getValue(),
                order.getId()
            ));
    }
}
