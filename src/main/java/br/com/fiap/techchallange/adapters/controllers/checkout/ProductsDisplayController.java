package br.com.fiap.techchallange.adapters.controllers.checkout;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.checkout.IProductsDisplayUseCase;

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
