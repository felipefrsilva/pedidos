package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IGetOrderPaymentUseCase;

import java.io.IOException;

public class GetOrderPaymentController {
    IGetOrderPaymentUseCase getOrderPaymentUseCase;

    public GetOrderPaymentController(IGetOrderPaymentUseCase getOrderPaymentUseCase) {
        this.getOrderPaymentUseCase = getOrderPaymentUseCase;
    }

    public OutputDataPaymentDTO getOrderPayment(String idOrder) throws  IOException {
        return getOrderPaymentUseCase.getOrderPayment(idOrder);
    }
}
