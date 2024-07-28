package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.IGetProductListUseCase;

import java.util.ArrayList;
import java.util.List;

public class GetProductListUseCase implements IGetProductListUseCase {

    IProductRepository repository;

    public GetProductListUseCase(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OutputDataProductDTO> getProducts() {
        List<Product> products = repository.getProducts();
        List<OutputDataProductDTO> productsDTO = new ArrayList<>();

        for(Product product: products){
            productsDTO.add(new OutputDataProductDTO(product.getSku(),
                                                  product.getName(),
                                                  product.getDescription(),
                                                  product.getMonetaryValue(),
                                                  product.getCategory()));
        }
        return productsDTO;
    }
}
