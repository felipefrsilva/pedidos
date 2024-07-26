package br.com.fiap.techchallange.core.usecase.inputboundary.checkout;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;

import java.util.List;

public interface IProductsDisplayUseCase {

    public List<OutputDataProductDTO> getProducts();

}
