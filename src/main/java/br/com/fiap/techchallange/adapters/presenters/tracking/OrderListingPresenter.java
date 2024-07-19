package br.com.fiap.techchallange.adapters.presenters.tracking;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.tracking.IOrderListingPresenter;

import java.util.ArrayList;
import java.util.List;

public class OrderListingPresenter implements IOrderListingPresenter {

    @Override
    public List<OrderViewModel> invoke(List<OutputDataOrderDTO> ordersDTO) {

        List<OrderViewModel> ordersView = new ArrayList<>();

        for(OutputDataOrderDTO outputDataOrderDTO: ordersDTO){
            ordersView.add(new OrderViewModel(outputDataOrderDTO.getId(),
                                              outputDataOrderDTO.getNumber_order(),
                                              outputDataOrderDTO.getStatus()));
        }

        return ordersView;
    }
}
