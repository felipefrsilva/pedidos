package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.InputDataProductDTO;
import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IUpdateProductUseCase;

public class UpdateProductUseCase implements IUpdateProductUseCase {
    IProductRepository repository;
    public UpdateProductUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    public void invoke(InputDataProductDTO productDTO) {
        Product product = new Product(productDTO.sku(), productDTO.name(), productDTO.description(), productDTO.monetaryValue(), productDTO.category());
        this.repository.updateProduct(product.getSku(), product);
    }
}
