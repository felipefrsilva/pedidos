package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.orderpreparation.IFinishingOfFoodPreparationController;
import br.com.fiap.techchallange.adapters.controllers.orderpreparation.IFoodPreparationController;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.infrastructure.ErrorReturn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/orderpreparation")
@Tag(name = "Order Preparation", description = "Endpoints para preparação do pedido.")
public class OrderPreparation {

    private final IFoodPreparationController prepareFood;
    private final IFinishingOfFoodPreparationController finishPrepareFood;

    public OrderPreparation(IFinishingOfFoodPreparationController finishPrepareFood,
                            IFoodPreparationController controllerPrepare){
        this.finishPrepareFood = finishPrepareFood;
        this.prepareFood = controllerPrepare;
    }

    @Operation(summary = "Coloca o pedido no status de preparação da comida")
    @PutMapping("/preparefood/{number_order}")
    public ResponseEntity<Map<String, String>> prepareFoodResponse(@PathVariable int number_order){
        prepareFood.invoke(number_order);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido em preparação");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Coloca o pedido no status de preparação da comida finalizada")
    @PutMapping("/finishfoodpreparation/{number_order}")
    public ResponseEntity<Map<String, String>> finishpreParationResponse(@PathVariable int number_order){
        finishPrepareFood.invoke(number_order);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido pronto para entrega ao cliente!");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorReturn> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorReturn error = new ErrorReturn(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
