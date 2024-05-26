package br.com.fiap.techchallange.application.usecases;

import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.application.dto.ItemDTO;
import br.com.fiap.techchallange.application.dto.OrderDTO;
import br.com.fiap.techchallange.application.ports.out.api.IGatewayPayment;
import br.com.fiap.techchallange.application.ports.out.api.IGenerateNumberOrder;
import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.domain.entity.Order;
import br.com.fiap.techchallange.domain.entity.Product;
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

    public void addProductToOrder(String idOrder, String sku, Integer qtd){
        Order order = repositoryOrder.get(idOrder);
        Product product = repositoryProduct.getProductBySku(sku);
        order.addProduct(product,qtd);
        repositoryOrder.addProduct(order, sku, qtd);
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
