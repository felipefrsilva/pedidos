package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentInitializeUseCase;

import java.io.IOException;

public class PaymentInitializeController {
    IPaymentInitializeUseCase paymentInitializeUseCase;

    public PaymentInitializeController(IPaymentInitializeUseCase paymentInitializeUseCase) {
        this.paymentInitializeUseCase = paymentInitializeUseCase;
    }

    public void initializePayment(String idOrder) throws IOException {
        this.paymentInitializeUseCase.initializePayment(idOrder);
    }
}
