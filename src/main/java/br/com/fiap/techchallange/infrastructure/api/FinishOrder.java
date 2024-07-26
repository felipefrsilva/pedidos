package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.orderpreparation.IDeliveryOfProductsController;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.ErrorViewModel;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/finishorder")
@Tag(name = "5. Finish Order", description = "Endpoints para encerrar o atendimento do pedido")
public class FinishOrder{

    private final IDeliveryOfProductsController deliveryOfProductsController;

    public FinishOrder(IDeliveryOfProductsController deliveryOfProductsController) {
        this.deliveryOfProductsController = deliveryOfProductsController;
    }

    @Operation(summary = "Cria o pedido para atendimento do cliente, que irá acompanha-lo até a entrega do produto")
    @PostMapping("/{number_order}")
    public ResponseEntity<Map<String, String>> initializeServiceResponse(@PathVariable int number_order){
        deliveryOfProductsController.invoke(number_order);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido " + number_order + " Finalizado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorViewModel> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorViewModel error = new ErrorViewModel(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
