package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ProductManagement;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductManagementAPI implements ProductManagement {

    private final ProductApplication productApplication;

    public ProductManagementAPI(){
        productApplication =  new ProductApplication();
    }

    @Override
    @GetMapping
    public List<Product> getProducts() {
        return productApplication.getProducts();
    }

    @GetMapping("/teste")
    public String Hello(){
        return "Hello World";
    }

    @Override
    @GetMapping("/sku/{sku}")
    public Product getProductBySku(@PathVariable String sku) {
        System.out.println("sku");
        return productApplication.getProductBySku(sku);
    }

    @Override
    @GetMapping("/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        return productApplication.getProductByName(name);
    }
}
