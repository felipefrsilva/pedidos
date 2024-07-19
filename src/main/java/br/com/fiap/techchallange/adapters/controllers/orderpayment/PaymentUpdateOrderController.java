package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IPaymentUpdateOrderUseCase;

import java.io.IOException;

public class PaymentUpdateOrderController {
    IPaymentUpdateOrderUseCase paymentUpdateOrderUseCase;

    public PaymentUpdateOrderController(IPaymentUpdateOrderUseCase paymentUpdateOrderUseCase) {
        this.paymentUpdateOrderUseCase = paymentUpdateOrderUseCase;
    }

    public void updateOrderPayment(String idOrder) throws IOException {
        this.paymentUpdateOrderUseCase.updateOrderPayment(idOrder);
    }
}
