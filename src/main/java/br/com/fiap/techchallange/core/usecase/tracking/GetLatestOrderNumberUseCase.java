package br.com.fiap.techchallange.core.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IGetLatestOrderNumberUseCase;

public class GetLatestOrderNumberUseCase implements IGetLatestOrderNumberUseCase {

    private IOrderRepository orderRepository;

    public GetLatestOrderNumberUseCase(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public int getLastNumber() {
        return this.orderRepository.getLastNumber();
    }
}
