package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.orders.domain.service.ServiceProductManagement;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ProductManagement;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductManagementAPI implements ProductManagement {

    private final ServiceProductManagement productService;

    public ProductManagementAPI(){
        productService =  new ServiceProductManagement();
    }

    @Override
    @GetMapping("/product/list")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @Override
    @GetMapping("/product/{sku}")
    public Product getProductBySku(@PathVariable String sku) {
        System.out.println("sku");
        return productService.getProductBySku(sku);
    }

    @Override
    @PostMapping("/product/create")
    public Product createProduct(Product product) {
        return this.productService.createProduct(product);
    }

    @Override
    @PostMapping("/product/{sku}/edit")
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    @PostMapping("/product/{sku}/remove")
    public void deleteProductBySku(String sku) {
    }
}
