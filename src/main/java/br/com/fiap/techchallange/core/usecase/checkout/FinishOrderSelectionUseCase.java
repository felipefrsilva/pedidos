package br.com.fiap.techchallange.core.usecase.checkout;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.vo.Item;
import br.com.fiap.techchallange.core.usecase.dto.order.InputDataItemDTO;
import br.com.fiap.techchallange.core.usecase.dto.order.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.checkout.IFinishOrderSelectionUseCase;

import java.util.ArrayList;
import java.util.List;

public class FinishOrderSelectionUseCase implements IFinishOrderSelectionUseCase {

    private final IOrderRepository orderRepository;;

    public FinishOrderSelectionUseCase(IOrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public OutputDataOrderDTO invoke(InputDataOrderDTO inputDataOrderDTO) {

        List<Item> items = new ArrayList<>();

        for(InputDataItemDTO item: inputDataOrderDTO.items()){
            items.add(new Item(inputDataOrderDTO.id(), item.sku(), item.quantity(), item.amount()));
        }

        Order order = new Order(inputDataOrderDTO.id(), items);

        this.orderRepository.create(order);

        return new OutputDataOrderDTO(order.getId(), order.getNumberOrder(), order.getStatus());
    }
}
