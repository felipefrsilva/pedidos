package br.com.fiap.techchallange.infrastructure.ports.out.repository;

import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

public interface IProductRepository {

    public List<Product> getProducts();
    public Product getProductBySku(String sku);
    public Product createProduct(Product product);
    public Product updateProduct(String sku, Product product);
    public void deleteProduct(String sku);
}
