package br.com.fiap.techchallange.adapters.controllers.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.ordercreation.OutputDataProductDTO;

import java.util.List;

public interface IProductsDisplayController {

    public List<OutputDataProductDTO> getProducts();
}
