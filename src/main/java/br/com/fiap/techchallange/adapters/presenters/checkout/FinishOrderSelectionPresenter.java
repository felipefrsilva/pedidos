package br.com.fiap.techchallange.adapters.presenters.checkout;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.checkout.IFinishOrderSelectionPresenter;

public class FinishOrderSelectionPresenter implements IFinishOrderSelectionPresenter {

    @Override
    public OrderViewModel invoke(OutputDataOrderDTO outputDataOrderDTO) {
        return new OrderViewModel(outputDataOrderDTO.id(), outputDataOrderDTO.number_order(), outputDataOrderDTO.status());
    }
}
