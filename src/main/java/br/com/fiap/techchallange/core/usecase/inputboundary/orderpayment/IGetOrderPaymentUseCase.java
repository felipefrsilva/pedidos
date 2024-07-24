package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;

import java.io.IOException;

public interface IGetOrderPaymentUseCase {
    OutputDataPaymentDTO getOrderPayment(String idOrder) throws IOException;
}
