package br.com.fiap.techchallange.core.usecase.ordercreation;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.vo.Item;
import br.com.fiap.techchallange.core.usecase.dto.ordercreation.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IFinishOrderSelectionUseCase;

import java.util.HashMap;
import java.util.Map;

public class FinishOrderSelectionUseCase implements IFinishOrderSelectionUseCase {

    private final IOrderRepository orderRepository;;

    public FinishOrderSelectionUseCase(IOrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void registerOrder(InputDataOrderDTO inputDataOrderDTO) {
        Order order = new Order(inputDataOrderDTO.getId(),
                                inputDataOrderDTO.getItems());

        this.orderRepository.create(order);

        HashMap<String, Item> items = inputDataOrderDTO.getItems();

        for(Map.Entry<String, Item> item : items.entrySet()){
            this.orderRepository.addProduct(order, item.getKey(), item.getValue().getQuantity());
        }
    }
}
