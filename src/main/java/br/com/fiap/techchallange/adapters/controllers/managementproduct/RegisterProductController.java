package br.com.fiap.techchallange.adapters.controllers.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.InputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IRegisterProductUseCase;

public class RegisterProductController implements IRegisterProductController {
    IRegisterProductUseCase registerProductUseCase;
    public RegisterProductController(IRegisterProductUseCase registerProductUseCase) {
        this.registerProductUseCase = registerProductUseCase;
    }

    @Override
    public void invoke(String sku, String name, String description, float monetaryValue, String category) {
        registerProductUseCase.invoke(new InputDataProductDTO(sku, name, description, monetaryValue, category));
    }
}
