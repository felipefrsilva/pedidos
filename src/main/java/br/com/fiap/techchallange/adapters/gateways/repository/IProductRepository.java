package br.com.fiap.techchallange.adapters.gateways.repository;

import br.com.fiap.techchallange.core.entity.Product;

import java.util.List;

public interface IProductRepository {

    public List<Product> getProducts();
    public Product getProductBySku(String sku);
    public List<Product> getProductsByCategory(String category);
    public void createProduct(Product product);
    public void updateProduct(String sku, Product product);
    public void deleteProduct(String sku);
}
