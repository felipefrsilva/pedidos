package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;

import java.io.IOException;

public interface IOrderPaymentController {
    public OutputDataPaymentDTO initializePayment(String idOrder) throws IOException;
}
