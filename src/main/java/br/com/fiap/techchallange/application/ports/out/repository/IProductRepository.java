package br.com.fiap.techchallange.application.ports.out.repository;

import br.com.fiap.techchallange.domain.entity.Product;

import java.util.List;

public interface IProductRepository {

    public List<Product> getProducts();
    public Product getProductBySku(String sku);
    public void createProduct(Product product);
    public void updateProduct(String sku, Product product);
    public void deleteProduct(String sku);
}
