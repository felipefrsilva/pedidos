package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import java.io.IOException;

public interface IPaymentInitializeUseCase {
    void initializePayment(String idOrder) throws IOException;
}
