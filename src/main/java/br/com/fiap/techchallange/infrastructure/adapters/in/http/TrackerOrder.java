package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.dto.TrackerOrderDTO;
import br.com.fiap.techchallange.application.ports.in.http.ITrackOrder;
import br.com.fiap.techchallange.application.usecases.TrackerOrderApplication;
import br.com.fiap.techchallange.domain.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.infrastructure.exceptions.ErrorReturn;
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

    @Operation(summary = "Coloca o pedido no status de preparação do produto")
    @PutMapping("/preparefood")
    public ResponseEntity<Map<String, String>> prepareFoodResponse(@RequestBody TrackerOrderDTO trackerOrder){
        prepareFood(trackerOrder.getOrderId());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido em preparação");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Coloca o pedido no status de preparação finalizada do produto")
    @PutMapping("/finishpreparation")
    public ResponseEntity<Map<String, String>> finishpreParationResponse(@RequestBody TrackerOrderDTO trackerOrder){
        finishPreparation(trackerOrder.getOrderId());
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pedido pronto para entrega");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Coloca o pedido no status de finalizado após entregar o produto para o cliente")
    @PutMapping("/deliverFood")
    public ResponseEntity<Map<String, String>> deliverFoodResponse(@RequestBody TrackerOrderDTO trackerOrder){
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
