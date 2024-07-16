package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.infrastructure.dto.OrderDTO;
import br.com.fiap.techchallange.infrastructure.dto.removeOrderDTO;
import br.com.fiap.techchallange.infrastructure.http.IServiceOrder;
import br.com.fiap.techchallange.core.usecase.ServiceOrderApplication;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.infrastructure.ErrorReturn;
import br.com.fiap.techchallange.infrastructure.factory.FactoryOrderApplication;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/service/orders")
@Tag(name = "3. Service Order", description = "Endpoints de inicialização do pedido e escolha dos produtos")
public class ServiceOrder implements IServiceOrder {

    ServiceOrderApplication serviceOrder;
    FactoryOrderApplication factory;

    @Autowired
    public void setFactory(FactoryOrderApplication factory) {
        this.factory = factory;
        this.serviceOrder = factory.createOrderApplication();
    }

    @Operation(summary = "Cria o pedido para atendimento do cliente, que irá acompanha-lo até a entrega do produto")
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> initializeServiceResponse(){
        String idOrder = initializeService();
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido criado com o id " + idOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Consulta o status do pedido")
    @GetMapping("/{idOrder}")
    public ResponseEntity<Map<String, OrderDTO>> getOrderResponse(@PathVariable String idOrder){
        OrderDTO order = getOrder(idOrder);
        Map<String, OrderDTO> response = new HashMap<>();
        response.put("order", order);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(summary = "Remove produtos do pedido")
    @DeleteMapping("/product")
    public ResponseEntity<Map<String, String>> removeProductToOrderResponse(@RequestBody removeOrderDTO removeOrder){
        removeProductToOrder(removeOrder.getIdOrder(), removeOrder.getSku());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Produto removido do pedido");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorReturn> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorReturn error = new ErrorReturn(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @Override
    public String initializeService() {
        return serviceOrder.initializeService();
    }


    @Override
    public void removeProductToOrder(String idOrder, String sku) {
        serviceOrder.removeProductToOrder(idOrder, sku);
    }


    @Override
    public OrderDTO getOrder(String idOrder) {
        return serviceOrder.getOrder(idOrder);
    }
}
