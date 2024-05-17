package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.infrastructure.adapters.in.ProductRequest;
import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

public interface IProductManagementHTTP {
    public List<Product> getProducts();
    public Product getProductBySku(String sku);
    public Product createProduct(ProductRequest productRequest);
    public Product updateProduct(String sku, ProductRequest productRequest);
    public void deleteProduct(String sku);
}
