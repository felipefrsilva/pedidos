package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

public interface ProductManagement {
    public List<Product> getProducts();
    public Product getProductBySku(String sku);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProductBySku(String sku);
}
