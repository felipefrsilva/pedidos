package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentGetReadingCodeUseCase;

import java.io.IOException;

public class PaymentGetReadingCodeController {
    IPaymentGetReadingCodeUseCase paymentGetReadingCodeUseCase;

    public PaymentGetReadingCodeController(IPaymentGetReadingCodeUseCase paymentGetReadingCodeUseCase) {
        this.paymentGetReadingCodeUseCase = paymentGetReadingCodeUseCase;
    }

    public String getReadingCode(String idOrder) throws IOException {
        return this.paymentGetReadingCodeUseCase.getReadingCode(idOrder);
    }
}
