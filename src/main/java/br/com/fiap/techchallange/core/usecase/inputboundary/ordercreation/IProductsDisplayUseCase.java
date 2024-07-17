package br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.ordercreation.OutputDataProductDTO;

import java.util.List;

public interface IProductsDisplayUseCase {

    public List<OutputDataProductDTO> getProducts();

}
