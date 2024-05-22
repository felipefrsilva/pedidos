package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.adapters.out.mysql.MySQLProductAdapter;
import br.com.fiap.techchallange.infrastructure.factory.FactoryProductRepository;
import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
public class ProductApplication {

//    IProductRepository repository;

//    public ProductApplication() {
//        this.repository = FactoryProductRepository.create();
//    }
    @Autowired
    MySQLProductAdapter repository;

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
