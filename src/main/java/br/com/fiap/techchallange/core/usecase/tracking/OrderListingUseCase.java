package br.com.fiap.techchallange.core.usecase.tracking;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IOrderListingUseCase;

import java.util.ArrayList;
import java.util.List;

public class OrderListingUseCase implements IOrderListingUseCase {

    private final IOrderRepository orderRepository;

    public OrderListingUseCase(IOrderRepository orderRepository){
        this.orderRepository =  orderRepository;
    }

    @Override
    public List<OutputDataOrderDTO> invoke() {
        List<Order> orders = orderRepository.getOrders();
        List<OutputDataOrderDTO> ordersDTO = new ArrayList<>();
        for(Order order: orders){
            ordersDTO.add(new OutputDataOrderDTO(order.getId(), order.getNumberOrder(), order.getStatus()));
        }

        return ordersDTO;
    }
}
