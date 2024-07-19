package br.com.fiap.techchallange.adapters.controllers.tracking;

import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IOrderListingUseCase;

import java.util.List;

public class OrderListingController implements IOrderListingController {

    private final IOrderListingUseCase orderListingUseCase;

    public OrderListingController(IOrderListingUseCase orderListingUseCase){
        this.orderListingUseCase = orderListingUseCase;
    }

    @Override
    public List<OutputDataOrderDTO> invoke() {
        return orderListingUseCase.invoke();
    }
}
