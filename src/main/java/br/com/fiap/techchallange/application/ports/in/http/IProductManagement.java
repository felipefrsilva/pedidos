package br.com.fiap.techchallange.application.ports.in.http;

import br.com.fiap.techchallange.domain.entity.Product;

import java.util.List;

public interface IProductManagement {
    public List<Product> getProducts();
    public Product getProductBySku(String sku);

    void createProduct(Product product);

    void updateProduct(String sku, Product product);

    void deleteProduct(String sku);
}