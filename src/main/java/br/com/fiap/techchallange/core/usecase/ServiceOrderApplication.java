package br.com.fiap.techchallange.core.usecase;

import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.infrastructure.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.infrastructure.dto.ItemDTO;
import br.com.fiap.techchallange.infrastructure.dto.OrderDTO;
import br.com.fiap.techchallange.adapters.gateways.service.IGatewayPayment;
import br.com.fiap.techchallange.adapters.gateways.service.IGenerateNumberOrder;
import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import com.google.zxing.WriterException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceOrderApplication {

    IOrderRepository repositoryOrder;
    IProductRepository repositoryProduct;
    IGatewayPayment gatewayPayment;
    IGenerateNumberOrder generateNumberOrder;

    public ServiceOrderApplication(IOrderRepository repositoryOrder,
                                   IProductRepository repositoryProduct,
                                   IGatewayPayment gatewayPayment,
                                   IGenerateNumberOrder generateNumberOrder){
       this.repositoryOrder = repositoryOrder;
       this.repositoryProduct = repositoryProduct;
       this.gatewayPayment = gatewayPayment;
       this.generateNumberOrder = generateNumberOrder;
    }

    public String initializeService(){
        Order order = new Order();
        repositoryOrder.create(order);
        return order.getId();
    }

    public void removeProductToOrder(String idOrder, String sku) {
        Order order = repositoryOrder.get(idOrder);
        order.removeProduct(sku);
        repositoryOrder.removeProduct(order, sku);
    }

    public void initializePayment(String idOrder) throws IOException, WriterException {
        Order order = repositoryOrder.get(idOrder);
        String codePayment = gatewayPayment.getCodeReading(order.getAmount());
        order.addReadingCodePayment(codePayment);
        repositoryOrder.updatePayment(order);
    }

    public void processPayment(CodeProcessingDTO codePayment){
        Order order = repositoryOrder.get(codePayment.getIdOrder());
        order.processingPayment(codePayment.getCode());
        order.setNumberOrder(this.generateNumberOrder.generate());
        repositoryOrder.updatePayment(order);
    }

    public OrderDTO getOrder(String idOrder){
        Order order = repositoryOrder.get(idOrder);
        return new OrderDTO(order.getId(),
                            order.getNumberOrder(),
                            this.getItems(order),
                            order.getStatus(),
                            order.getAmount(),
                            order.getCodeReadingPayment(),
                            order.getCodeProcessingPayment());
    }

    private List<ItemDTO> getItems(Order order) {
        List<ItemDTO> items = new ArrayList<>();

        for (Map.Entry<String, Float> entry : order.getValueProducts().entrySet()) {
            ItemDTO item =  new ItemDTO(entry.getKey(), entry.getValue(), order.getQtdProduct(entry.getKey()));

            items.add(item);
        }

        return items;
    }


}
