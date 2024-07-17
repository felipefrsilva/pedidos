package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.ordercreation.IFinishOrderSelectionController;
import br.com.fiap.techchallange.adapters.controllers.ordercreation.IProductsDisplayController;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.ICustomerPresenter;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.IProductPresenter;
import br.com.fiap.techchallange.infrastructure.dto.OrderRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ordercreation")
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

    @Operation(summary = "Busca o usuário pelo CPF na base de dados. Deve conter apenas números!")
    @GetMapping("/products")
    public ResponseEntity<?> getProducts() throws EmptyResultDataAccessException {
        try {
            List<IProductPresenter.ProductResponseModel> response = productPresenterJson.present(this.productsDisplayController.getProducts());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("Produtos não encontradoa na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Busca o usuário pelo CPF na base de dados. Deve conter apenas números!")
    @PostMapping("/orders")
    public ResponseEntity<?> registerOrder(@RequestBody OrderRequestDTO orderDeserializer) throws EmptyResultDataAccessException {
        try {
            this.productsDisplayController.getProducts();
            return new ResponseEntity<>("Order Registrada no sistema", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("Ocorreu um problema ao registrar a order de serviço"), HttpStatus.BAD_REQUEST);
        }
    }
}
