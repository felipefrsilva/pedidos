package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentCheckStatusUseCase;

import java.io.IOException;

public class PaymentCheckStatusController {
    IPaymentCheckStatusUseCase paymentCheckStatusUseCase;

    public PaymentCheckStatusController(IPaymentCheckStatusUseCase paymentCheckStatusUseCase) {
        this.paymentCheckStatusUseCase = paymentCheckStatusUseCase;
    }

    public String checkStatus(String idOrder) throws IOException {
        return  paymentCheckStatusUseCase.checkPaymentStatus(idOrder);
    }
}
