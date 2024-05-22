package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.domain.entity.Product;

import java.util.List;

public class ProductApplication {

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

    public void deleteProduct(String sku) {
        repository.deleteProduct(sku);
    }

    public void createProduct(Product product) {
        repository.createProduct(product);
    }

    public void updateProduct(String sku, Product product) {
        repository.updateProduct(sku, product);
    }
}
