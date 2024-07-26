package br.com.fiap.techchallange.adapters.controllers.checkout;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;

import java.util.List;

public interface IProductsDisplayController {

    public List<OutputDataProductDTO> getProducts();
}
