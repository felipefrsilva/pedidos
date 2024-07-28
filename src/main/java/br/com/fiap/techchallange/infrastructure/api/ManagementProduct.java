package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.managementproduct.*;
import br.com.fiap.techchallange.adapters.presenters.viewmodel.ErrorViewModel;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.managementproduct.IProductManagementPresenter;
import br.com.fiap.techchallange.infrastructure.dto.ProductRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "8. Management Product", description = "Endpoints para a gestão do cadastro dos produtos")
public class ManagementProduct {

    IGetProductListController getProductListController;
    IGetProductBySkuController getProductBySkuController;
    IRegisterProductController registerProductController;
    IUpdateProductController updateProductController;
    IRemoveProductController removeProductController;
    IProductManagementPresenter productPresenter;

    public ManagementProduct(
        IGetProductListController getProductListController,
        IGetProductBySkuController getProductBySkuController,
        IRegisterProductController registerProductController,
        IUpdateProductController updateProductController,
        IRemoveProductController removeProductController,
        IProductManagementPresenter productPresenter
    ) {
        this.getProductListController = getProductListController;
        this.getProductBySkuController = getProductBySkuController;
        this.registerProductController = registerProductController;
        this.updateProductController = updateProductController;
        this.removeProductController = removeProductController;
        this.productPresenter = productPresenter;
    }

    @Operation(summary = "Busca os produtos para a exibição ao cliente.")
    @GetMapping("/products")
    // Este endpoint é duplicado com o /v1/checkout/products, no entanto são contextos diferentes (apresentação do checkout vs gestão de produtos)
    public ResponseEntity<?> getProducts() throws EmptyResultDataAccessException {
        try {
            List<IProductManagementPresenter.ProductResponseModel> response = productPresenter.presentList(this.getProductListController.getProducts());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(1,"Produtos não encontradoa na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{sku}")
    public ResponseEntity<?> getProductBySkuHTTP(@PathVariable String sku) {
        try {
            IProductManagementPresenter.ProductResponseModel response = productPresenter.present(this.getProductBySkuController.invoke(sku));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(1,"Produto não encontrado na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product/create")
    public ResponseEntity<?> createProductHTTP(@RequestBody ProductRequestDTO productDeserializer) {
        try {
            this.registerProductController.invoke(
                    productDeserializer.sku(),
                    productDeserializer.name(),
                    productDeserializer.description(),
                    productDeserializer.monetaryValue(),
                    productDeserializer.category()
            );
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(3, "Erro ao realizar cadastro de produto"), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorViewModel(99, e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return null;
    }

    @PutMapping("/product/{sku}/update")
    public ResponseEntity<?> updateProductHTTP(@PathVariable String sku, @RequestBody ProductRequestDTO productDeserializer) {
        try {
            this.updateProductController.invoke(
                    sku,
                    productDeserializer.name(),
                    productDeserializer.description(),
                    productDeserializer.monetaryValue(),
                    productDeserializer.category()
            );

        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(5, "Produto não encontrado"), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ErrorViewModel(99, e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK);
    }

    @PostMapping("/product/{sku}/remove")
    public ResponseEntity<?> deleteProductBySkuHTTP(@PathVariable String sku) {
        try {
            this.removeProductController.invoke(sku);
            return new ResponseEntity<>("Produto excluído com sucesso", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ErrorViewModel(6, "Produto não encontrado"), HttpStatus.NOT_FOUND);
        }
    }

}