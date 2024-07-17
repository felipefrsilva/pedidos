package br.com.fiap.techchallange.adapters.controllers.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.ordercreation.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IProductsDisplayUseCase;

import java.util.List;

public class ProductsDisplayController implements IProductsDisplayController {

    IProductsDisplayUseCase productsDisplayUseCase;

    public ProductsDisplayController(IProductsDisplayUseCase productsDisplayUseCase){
        this.productsDisplayUseCase = productsDisplayUseCase;
    }

    @Override
    public List<OutputDataProductDTO> getProducts() {
        return this.productsDisplayUseCase.getProducts();
    }
}
