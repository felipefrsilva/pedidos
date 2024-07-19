package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.tracking.IOrderListingController;
import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.tracking.IOrderListingPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tracker/orders")
@Tag(name = "5. Tracker Order", description = "Endpoints para o rastreamento dos pedidos.")
public class TrackerOrder {

    private final IOrderListingPresenter orderListingPresenter;
    private final IOrderListingController orderListingController;

    public TrackerOrder(IOrderListingPresenter orderListingPresenter,
                        IOrderListingController orderListingController){
        this.orderListingController = orderListingController;
        this.orderListingPresenter = orderListingPresenter;
    }

    @Operation(summary = "Busca os pedidos que estão no processo de atendimento")
    @GetMapping("/list")
    public ResponseEntity<List<OrderViewModel>> getOrders(){
        List<OrderViewModel> response = orderListingPresenter.invoke(orderListingController.invoke());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
