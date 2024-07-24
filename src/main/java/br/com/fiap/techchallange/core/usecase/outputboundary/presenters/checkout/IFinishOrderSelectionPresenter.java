package br.com.fiap.techchallange.core.usecase.outputboundary.presenters.checkout;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;

public interface IFinishOrderSelectionPresenter {

    public OrderViewModel invoke(OutputDataOrderDTO outputDataOrderDTO);

}
