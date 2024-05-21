package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.application.ports.in.http.IProductManagement;
import br.com.fiap.techchallange.domain.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders/product")
@Component
public class ProductManagementHTTP implements IProductManagement {

    private final ProductApplication productApplication;

    public ProductManagementHTTP(){
        productApplication =  new ProductApplication();
    }

    @Override
    @GetMapping("/list")
    public List<Product> getProducts() {
        return productApplication.getProducts();
    }

    @Override
    @GetMapping("/sku/{sku}")
    public Product getProductBySku(@PathVariable String sku) {
        return productApplication.getProductBySku(sku);
    }


}
