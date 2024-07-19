package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import java.io.IOException;

public interface IPaymentUpdateOrderUseCase {
    void updateOrderPayment(String idOrder) throws IOException;
}
