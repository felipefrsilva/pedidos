package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductManagementHTTP {

    private final ProductApplication productApplication;

    public ProductManagementHTTP(){
        productApplication =  new ProductApplication();
    }

    @GetMapping("/product/list")
    public ResponseEntity<List<ProductDeserializer>> getProducts() {
        List<Product> productList = this.productApplication.getProducts();
        List<ProductDeserializer> response;
        response = productList.stream().map((product) -> new ProductDeserializer(product)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/product/{sku}")
    public ResponseEntity<ProductDeserializer> getProductBySku(@PathVariable String sku) {
        Product product = this.productApplication.getProductBySku(sku);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ProductDeserializer response = new ProductDeserializer(product);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/product/create")
    public ResponseEntity<ProductDeserializer> createProduct(@RequestBody ProductDeserializer productDeserializer) {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDeserializer.monetaryValue()));
        Product newProduct = new Product(
                productDeserializer.sku(), productDeserializer.name(), productDeserializer.description(), monetaryValue, productDeserializer.category()
        );
        this.productApplication.createProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDeserializer(newProduct));

    }

    @PutMapping("/product/{sku}/update")
    public ResponseEntity<ProductDeserializer> updateProduct(@PathVariable String sku, @RequestBody ProductDeserializer productDeserializer) {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDeserializer.monetaryValue()));
        Product newProduct = new Product(
                productDeserializer.sku(), productDeserializer.name(), productDeserializer.description(), monetaryValue, productDeserializer.category()
        );
        return ResponseEntity.status(HttpStatus.OK).body(new ProductDeserializer(newProduct));
    }

    @PostMapping("/product/{sku}/remove")
    public void deleteProductBySku(@PathVariable String sku) {
        this.productApplication.deleteProduct(sku);
    }
}
