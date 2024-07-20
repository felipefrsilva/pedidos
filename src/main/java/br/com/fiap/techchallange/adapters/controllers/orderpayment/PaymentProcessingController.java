package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.entity.enums.StatusPayment;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentProcessingUseCase;

import java.io.IOException;

public class PaymentProcessingController {
    IPaymentProcessingUseCase paymentUpdateOrderUseCase;

    public PaymentProcessingController(IPaymentProcessingUseCase paymentUpdateOrderUseCase) {
        this.paymentUpdateOrderUseCase = paymentUpdateOrderUseCase;
    }

    public void processPayment(String idOrder, String processingCode, String statusPayment) throws IOException {
        this.paymentUpdateOrderUseCase.processPayment(idOrder, processingCode, StatusPayment.fromValue(statusPayment));
    }
}
