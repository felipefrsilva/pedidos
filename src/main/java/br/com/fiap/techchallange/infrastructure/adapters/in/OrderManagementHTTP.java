package br.com.fiap.techchallange.infrastructure.adapters.in;


import br.com.fiap.techchallange.application.OrderApplication;
import br.com.fiap.techchallange.application.dto.ItemOrderDTO;
import br.com.fiap.techchallange.application.dto.OrderDTO;
import br.com.fiap.techchallange.application.ports.in.http.IOrderManagement;
import br.com.fiap.techchallange.application.ports.out.api.IGatewayPayment;
import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.infrastructure.factory.FactoryGatewayPayment;
import br.com.fiap.techchallange.infrastructure.factory.FactoryOrderRepository;
import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import com.google.zxing.WriterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ordersmanagement/order")
public class OrderManagementHTTP implements IOrderManagement {

    OrderApplication orderApplication;

    public OrderManagementHTTP(){
        orderApplication = new OrderApplication(FactoryOrderRepository.create(), FactoryProductRepository.create(), FactoryGatewayPayment.create());
    }

    @PostMapping("/initializeservice")
    public ResponseEntity<Map<String, String>> initializeServiceResponse(){
        String idOrder = initializeService();
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido criado com o id " + idOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/id/{idOrder}")
    public ResponseEntity<Map<String, OrderDTO>> getOrderResponse(@PathVariable String idOrder){
        OrderDTO order = getOrder(idOrder);
        Map<String, OrderDTO> response = new HashMap<>();
        response.put("order", order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Map<String, String>> addProductToOrderResponse(@RequestBody ItemOrderDTO itemOrder){
        addProductToOrder(itemOrder.getIdOrder(), itemOrder.getItem().getSku(), itemOrder.getItem().getQtd());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Produto adicionado no pedido");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/removeProduct")
    public ResponseEntity<Map<String, String>> removeProductToOrderResponse(@RequestBody ItemOrderDTO itemOrder){
        removeProductToOrder(itemOrder.getIdOrder(), itemOrder.getItem().getSku());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Produto removido do pedido");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/finalizeservice")
    public ResponseEntity<Map<String, String>> finalizeServiceResponse(@RequestBody OrderDTO order) {
        try {
            finalizeService(order.getId());
        }catch (WriterException | IOException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Ocorreu um erro na finalização do pedido. Erro=" + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Map<String, String> response = new HashMap<>();
        response.put("status", "Código de leitura gerado para pagamento.");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Override
    public String initializeService() {
        return orderApplication.initializeService();
    }

    @Override
    public void addProductToOrder(String idOrder, String sku, Integer qtd) {
        orderApplication.addProductToOrder(idOrder, sku,qtd);
    }

    @Override
    public void removeProductToOrder(String idOrder, String sku) {
        orderApplication.removeProductToOrder(idOrder, sku);
    }

    @Override
    public void finalizeService(String idOrder) throws IOException, WriterException {
            orderApplication.finalizeService(idOrder);
    }

    @Override
    public OrderDTO getOrder(String idOrder) {
        return orderApplication.getOrder(idOrder);
    }
}
