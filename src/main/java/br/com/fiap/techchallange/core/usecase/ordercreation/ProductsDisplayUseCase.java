package br.com.fiap.techchallange.core.usecase.ordercreation;


import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.core.usecase.dto.ordercreation.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IProductsDisplayUseCase;

import java.util.ArrayList;
import java.util.List;

public class ProductsDisplayUseCase implements IProductsDisplayUseCase {

    IProductRepository productRepository;

    public ProductsDisplayUseCase(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<OutputDataProductDTO> getProducts(){
        List<Product> products = productRepository.getProducts();
        List<OutputDataProductDTO> productsDTO =  new ArrayList<>();
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
