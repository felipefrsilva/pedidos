package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;

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
