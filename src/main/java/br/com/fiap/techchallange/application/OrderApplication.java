package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.application.dto.ItemDTO;
import br.com.fiap.techchallange.application.dto.OrderDTO;
import br.com.fiap.techchallange.application.ports.out.api.IGatewayPayment;
import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.domain.entity.Order;
import br.com.fiap.techchallange.domain.entity.Product;
import com.google.zxing.WriterException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderApplication {

    IOrderRepository repositoryOrder;
    IProductRepository repositoryProduct;
    IGatewayPayment gatewayPayment;

    public OrderApplication(IOrderRepository repositoryOrder, IProductRepository repositoryProduct, IGatewayPayment gatewayPayment){
       this.repositoryOrder = repositoryOrder;
       this.repositoryProduct = repositoryProduct;
       this.gatewayPayment = gatewayPayment;
    }

    public String initializeService(){
        Order order = new Order();
        repositoryOrder.addOrder(order);
        return order.getId();
    }

    public void addProductToOrder(String idOrder, String sku, Integer qtd){
        Product product = repositoryProduct.getProductBySku(sku);
        Order order = repositoryOrder.getOrder(idOrder);
        order.addProduct(product, qtd);
    }

    public void removeProductToOrder(String idOrder, String sku) {
        Order order = repositoryOrder.getOrder(idOrder);
        order.removeProduct(sku);
    }

    public void finalizeService(String idOrder) throws IOException, WriterException {
        Order order = repositoryOrder.getOrder(idOrder);
        String codePayment = gatewayPayment.getCodeReading(order.getAmount());
        order.addReadingCodePayment(codePayment);
        repositoryOrder.update(order);
    }

    public void processPayment(CodeProcessingDTO codePayment){
        Order order = repositoryOrder.getOrder(codePayment.getIdOrder());
        order.processingPayment(codePayment.getCode());
        repositoryOrder.update(order);
    }

    public OrderDTO getOrder(String idOrder){
        Order order = repositoryOrder.getOrder(idOrder);
        return new OrderDTO(order.getId(),
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
