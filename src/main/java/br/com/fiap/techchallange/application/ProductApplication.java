package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.adapters.out.exception.MemorySkuAlreadyExists;
import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import br.com.fiap.techchallange.infrastructure.ports.in.http.IProductManagement;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

// TODO: Validate if it's the application that must implement the ports
public class ProductApplication implements IProductManagement {

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

    public Product createProduct(Product product)  {
        return this.repository.createProduct(product);
    }

    public Product updateProduct(String sku, Product product) {
        return this.repository.updateProduct(sku, product);
    }

    public void deleteProduct(String sku) {
        this.repository.deleteProduct(sku);
    }
}
