package br.com.fiap.techchallange.adapters.controllers.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IGetProductBySkuUseCase;

public class GetProductBySkuController implements IGetProductBySkuController {
    IGetProductBySkuUseCase getProductBySkuUseCase;
    public GetProductBySkuController(IGetProductBySkuUseCase getProductBySkuUseCase) {
        this.getProductBySkuUseCase = getProductBySkuUseCase;
    }

    @Override
    public OutputDataProductDTO invoke(String sku) {
        return getProductBySkuUseCase.get(sku);
    }
}
