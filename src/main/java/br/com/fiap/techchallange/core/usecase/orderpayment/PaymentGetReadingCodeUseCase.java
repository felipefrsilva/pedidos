package br.com.fiap.techchallange.core.usecase.orderpayment;

import br.com.fiap.techchallange.adapters.gateways.service.IPaymentGateway;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentGetReadingCodeUseCase;

import java.io.IOException;

public class PaymentGetReadingCodeUseCase implements IPaymentGetReadingCodeUseCase {
    IPaymentGateway gatewayPayment;

    public PaymentGetReadingCodeUseCase(IPaymentGateway gatewayPayment) {
        this.gatewayPayment = gatewayPayment;
    }

    @Override
    public String getReadingCode(String idOrder) throws IOException {
        Payment payment = this.gatewayPayment.getPayment(idOrder);
        return payment.getReadingCode();
    }
}
