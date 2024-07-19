package br.com.fiap.techchallange.adapters.controllers.orderpayment;

import br.com.fiap.techchallange.core.usecase.dto.ordercreation.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment.IOrderPaymentUseCase;

import java.io.IOException;

public class OrderPaymentController implements IOrderPaymentController {
    IOrderPaymentUseCase orderPaymentUseCase;

    public OrderPaymentController(IOrderPaymentUseCase orderPaymentUseCase) {
        this.orderPaymentUseCase = orderPaymentUseCase;
    }

    public OutputDataPaymentDTO initializePayment(String idOrder) throws IOException {
        // TODO: Call the use case for retrieving the order.
        InputDataOrderDTO inputDataOrderDTO = new InputDataOrderDTO(idOrder);
        return orderPaymentUseCase.initializePayment(inputDataOrderDTO);
    }
}
