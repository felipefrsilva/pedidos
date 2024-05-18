package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.infrastructure.adapters.out.exception.MemorySkuAlreadyExists;
import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

public interface IProductManagement {
    public List<Product> getProducts();
    public Product getProductBySku(String sku);
    public Product createProduct(Product product) throws MemorySkuAlreadyExists;
    public Product updateProduct(String sku, Product product);
    public void deleteProduct(String sku);
}
