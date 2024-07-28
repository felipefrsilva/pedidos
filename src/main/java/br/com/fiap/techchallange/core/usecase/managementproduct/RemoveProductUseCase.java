package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IRemoveProductUseCase;

public class RemoveProductUseCase implements IRemoveProductUseCase {
    IProductRepository repository;
    public RemoveProductUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void invoke(String sku) {
        repository.deleteProduct(sku);
    }
}
