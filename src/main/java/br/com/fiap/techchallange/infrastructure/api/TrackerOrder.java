package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.infrastructure.dto.OrderIdDTO;
import br.com.fiap.techchallange.infrastructure.dto.TrackerOrderDTO;
import br.com.fiap.techchallange.infrastructure.http.ITrackOrder;
import br.com.fiap.techchallange.core.usecase.TrackerOrderApplication;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.infrastructure.ErrorReturn;
import br.com.fiap.techchallange.infrastructure.factory.FactoryTrackerOrderApplication;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/tracker/orders")
@Tag(name = "5. Tracker Order", description = "Endpoints de acompanhamento da preparação do produto.")
public class TrackerOrder implements ITrackOrder {

    TrackerOrderApplication trackerOrder;
    FactoryTrackerOrderApplication factory;

    @Autowired
    public void setFactory(FactoryTrackerOrderApplication factory) {
        this.factory = factory;
        this.trackerOrder = factory.createTrackerOrder();
    }

    @Operation(summary = "Consulta o status do pedido na preparação do produto")
    @GetMapping("/{idOrder}")
    public ResponseEntity<Map<String, TrackerOrderDTO>> getOrderResponse(@PathVariable String idOrder){
        TrackerOrderDTO trackerOrder = getTracker(idOrder);
        Map<String, TrackerOrderDTO> response = new HashMap<>();
        response.put("trackerOrder", trackerOrder);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(summary = "Coloca o pedido no status de finalizado após entregar o produto para o cliente")
    @PutMapping("/deliverFood")
    public ResponseEntity<Map<String, String>> deliverFoodResponse(@RequestBody OrderIdDTO trackerOrder){
        deliverFood(trackerOrder.getOrderId());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido Finalizado");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorReturn> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorReturn error = new ErrorReturn(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @Override
    public TrackerOrderDTO getTracker(String orderId) {
        return this.trackerOrder.getTracker(orderId);
    }

    @Override
    public void prepareFood(String orderId) {
        this.trackerOrder.prepareFood(orderId);
    }

    @Override
    public void finishPreparation(String orderId) {
        this.trackerOrder.finishPreparation(orderId);
    }

    @Override
    public void deliverFood(String orderId) {
        this.trackerOrder.deliverFood(orderId);
    }
}
