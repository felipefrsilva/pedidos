package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.ordercreation.IFinishOrderSelectionController;
import br.com.fiap.techchallange.adapters.controllers.ordercreation.IProductsDisplayController;
import br.com.fiap.techchallange.adapters.presenters.viewmodel.ErrorViewModel;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.ordercreation.IProductPresenter;
import br.com.fiap.techchallange.infrastructure.dto.OrderRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ordercreation")
@Tag(name = "Order Creation", description = "Endpoints para a criação de pedido do cliente.")
public class OrderCreation {

    IProductsDisplayController productsDisplayController;
    IFinishOrderSelectionController finishOfOrderController;
    IProductPresenter productPresenterJson;

    public OrderCreation(IProductPresenter productPresenterJson,
                         IProductsDisplayController productsDisplayController,
                         IFinishOrderSelectionController finishOfOrderController){
        this.productsDisplayController = productsDisplayController;
        this.productPresenterJson = productPresenterJson;
    }

    @Operation(summary = "Busca os produtos para a exibição ao cliente.")
    @GetMapping("/products")
    public ResponseEntity<?> getProducts() throws EmptyResultDataAccessException {
        try {
            List<IProductPresenter.ProductResponseModel> response = productPresenterJson.present(this.productsDisplayController.getProducts());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel("Produtos não encontradoa na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Envia o pedido para cadastro base de dados.")
    @PostMapping("/orders")
    public ResponseEntity<?> registerOrder(@RequestBody OrderRequestDTO orderDeserializer) throws EmptyResultDataAccessException {
        try {
            this.productsDisplayController.getProducts();
            return new ResponseEntity<>("Order Registrada no sistema", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel("Ocorreu um problema ao registrar a order de serviço"), HttpStatus.BAD_REQUEST);
        }
    }
}
