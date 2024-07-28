package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.InputDataProductDTO;
import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IRegisterProductUseCase;

public class RegisterProductUseCase implements IRegisterProductUseCase {
    IProductRepository repository;
    public RegisterProductUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void invoke(InputDataProductDTO inputDataProductDTO) {
        Product product = new Product(inputDataProductDTO.sku(), inputDataProductDTO.name(), inputDataProductDTO.description(), inputDataProductDTO.monetaryValue(), inputDataProductDTO.category());
        this.repository.createProduct(product);
    }
}
