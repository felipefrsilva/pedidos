package br.com.fiap.techchallange.core.usecase.outputboundary.presenters.tracking;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;

import java.util.List;

public interface IOrderListingPresenter {
    public List<OrderViewModel> invoke(List<OutputDataOrderDTO> ordersDTO);
}
