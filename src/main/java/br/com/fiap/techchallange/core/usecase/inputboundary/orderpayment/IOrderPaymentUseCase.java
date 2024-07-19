package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import br.com.fiap.techchallange.core.usecase.dto.ordercreation.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;

import java.io.IOException;

public interface IOrderPaymentUseCase {
    public OutputDataPaymentDTO initializePayment(InputDataOrderDTO inputDataOrderDTO) throws IOException;
}
