package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import br.com.fiap.techchallange.core.entity.enums.StatusPayment;

import java.io.IOException;

public interface IPaymentProcessingUseCase {
    void processPayment(String idOrder, String processingCode, StatusPayment statusPayment) throws IOException;
}
