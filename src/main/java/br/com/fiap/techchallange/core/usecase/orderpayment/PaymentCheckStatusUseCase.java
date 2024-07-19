package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentCheckStatusUseCase;

import java.io.IOException;

public class PaymentCheckStatusUseCase implements IPaymentCheckStatusUseCase {
    IPaymentGateway gatewayPayment;

    public PaymentCheckStatusUseCase(IPaymentGateway gatewayPayment) {
        this.gatewayPayment = gatewayPayment;
    }

    @Override
    public String checkPaymentStatus(String idOrder) throws IOException {
        Payment payment = this.gatewayPayment.getPayment(idOrder);
        return payment.getStatus();
    }
}
