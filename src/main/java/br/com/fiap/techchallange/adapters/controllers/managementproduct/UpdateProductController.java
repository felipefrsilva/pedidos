package br.com.fiap.techchallange.adapters.controllers.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.InputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IUpdateProductUseCase;

public class UpdateProductController implements IUpdateProductController {
    IUpdateProductUseCase updateProductUseCase;
    public UpdateProductController(IUpdateProductUseCase updateProductUseCase) {
        this.updateProductUseCase = updateProductUseCase;
    }


    @Override
    public void invoke(String sku, String name, String description, float monetaryValue, String category) {
        updateProductUseCase.invoke(new InputDataProductDTO(sku, name, description, monetaryValue, category));
    }
}
