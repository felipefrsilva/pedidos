package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.infrastructure.adapters.out.exception.MemorySkuAlreadyExists;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductManagementHTTP {

    private final ProductApplication productApplication;

    public ProductManagementHTTP(){
        productApplication =  new ProductApplication();
    }

    @GetMapping("/product/list")
    public List<Product> getProducts() {
        return productApplication.getProducts();
    }

    @GetMapping("/product/{sku}")
    public Product getProductBySku(@PathVariable String sku) {
        System.out.println("sku");
        return productApplication.getProductBySku(sku);
    }

    @PostMapping("/product/create")
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        try {
            return this.productApplication.createProduct(productRequest);
        } catch (MemorySkuAlreadyExists e) {
            throw new RuntimeException("Product Already Exists");
        }

    }

    @PutMapping("/product/{sku}/update")
    public Product updateProduct(@PathVariable String sku, @RequestBody ProductRequest productRequest) {
        return this.productApplication.updateProduct(sku, productRequest);
    }

    @PostMapping("/product/{sku}/remove")
    public void deleteProductBySku(@PathVariable String sku) {
        this.productApplication.deleteProduct(sku);
    }
}
