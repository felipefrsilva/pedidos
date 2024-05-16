package br.com.fiap.techchallange.orders.domain.service;

import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

public class ServiceProductManagement {

    IProductRepository repository;

    public ServiceProductManagement() {
        this.repository = FactoryProductRepository.create();
    }


    public List<Product> getProducts() {
        return this.repository.getProducts();
    }

    public Product getProductBySku(String sku) {
        return this.repository.getProductBySku(sku);
    }

    public Product createProduct(Product product) {
        return this.repository.createProduct(product);
    }
    public Product updateProduct(Product product) {return  null;}
    public void deleteProductBySku(String sku) {return;}

}
