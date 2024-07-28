package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IGetProductBySkuUseCase;

public class GetProductBySkuUseCase implements IGetProductBySkuUseCase {
    IProductRepository repository;
    public GetProductBySkuUseCase(IProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public OutputDataProductDTO get(String sku) {
        Product product = this.repository.getProductBySku(sku);
        return new OutputDataProductDTO(
                product.getSku(),
                product.getName(),
                product.getDescription(),
                product.getMonetaryValue(),
                product.getCategory()
        );
    }
}
