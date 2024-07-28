package br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;

import java.util.List;

public interface IGetProductListUseCase {
    public List<OutputDataProductDTO> getProducts();
}
