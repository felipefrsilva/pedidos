package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import java.io.IOException;

public interface IPaymentCheckStatusUseCase {
    String checkPaymentStatus(String idOrder) throws IOException;
}
