package br.com.fiap.techchallange.adapters.controllers.managementproduct;

import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IRemoveProductUseCase;

public class RemoveProductController implements IRemoveProductController {
    IRemoveProductUseCase removeProductUseCase;
    public RemoveProductController(IRemoveProductUseCase removeProductUseCase) {
        this.removeProductUseCase = removeProductUseCase;
    }

    @Override
    public void invoke(String sku) {
        removeProductUseCase.invoke(sku);
    }
}
