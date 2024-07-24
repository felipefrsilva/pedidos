package br.com.fiap.techchallange.adapters.presenters.orderpayment;

import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.IOrderPaymentPresenter;

public class OrderPaymentPresenterJson implements IOrderPaymentPresenter {

    @Override
    public OrderPaymentResponseModel present(OutputDataPaymentDTO outputDataPaymentDTO) {
        return new OrderPaymentResponseModel(outputDataPaymentDTO);
    }
}
