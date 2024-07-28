package br.com.fiap.techchallange.adapters.controllers.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IGetProductListUseCase;

import java.util.List;

public class GetProductListController implements IGetProductListController {
    IGetProductListUseCase getProductListUseCase;
    public GetProductListController(IGetProductListUseCase getProductListUseCase) {
        this.getProductListUseCase = getProductListUseCase;
    }

    @Override
    public List<OutputDataProductDTO> getProducts() {
        return this.getProductListUseCase.getProducts();
    }
}
