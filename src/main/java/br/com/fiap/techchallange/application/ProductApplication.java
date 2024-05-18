package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.adapters.in.ProductRequest;
import br.com.fiap.techchallange.infrastructure.adapters.out.exception.MemorySkuAlreadyExists;
import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import br.com.fiap.techchallange.infrastructure.ports.in.http.IProductManagementHTTP;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;

import java.math.BigDecimal;
import java.util.List;

// TODO: Validate if it's the application that must implement the ports
public class ProductApplication implements IProductManagementHTTP {

    IProductRepository repository;

    public ProductApplication() {
        this.repository = FactoryProductRepository.create();
    }


    public List<Product> getProducts() {
        return this.repository.getProducts();
    }

    public Product getProductBySku(String sku) {
        return this.repository.getProductBySku(sku);
    }

    public Product createProduct(ProductRequest productRequest) throws MemorySkuAlreadyExists {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productRequest.monetaryValue()));
        Product newProduct = new Product(
                productRequest.sku(), productRequest.name(), productRequest.description(), monetaryValue, productRequest.category()
        );
        return this.repository.createProduct(newProduct);
    }

    public Product updateProduct(String sku, ProductRequest productRequest) {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productRequest.monetaryValue()));
        Product newProduct = new Product(
                productRequest.sku(), productRequest.name(), productRequest.description(), monetaryValue, productRequest.category()
        );
        return this.repository.updateProduct(sku, newProduct);
    }

    public void deleteProduct(String sku) {
        this.repository.deleteProduct(sku);
    }
}
