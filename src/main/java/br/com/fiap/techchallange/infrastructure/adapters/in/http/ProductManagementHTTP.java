package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.IProductManagement;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductManagementHTTP implements IProductManagement {

    @Autowired
    private ProductApplication productApplication;


    @GetMapping("/product/list")
    public ResponseEntity<List<ProductRequestDTO>> getProductsHTTP() {
        List<Product> productList = this.getProducts();
        List<ProductRequestDTO> response;
        response = productList.stream().map((product) -> new ProductRequestDTO(product)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/product/{sku}")
    public ResponseEntity<ProductRequestDTO> getProductBySkuHTTP(@PathVariable String sku) {
        Product product = this.getProductBySku(sku);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ProductRequestDTO response = new ProductRequestDTO(product);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/product/create")
    public ResponseEntity<ProductRequestDTO> createProductHTTP(@RequestBody ProductRequestDTO productDeserializer) {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDeserializer.monetaryValue()));
        Product newProduct = new Product(
                productDeserializer.sku(), productDeserializer.name(), productDeserializer.description(), monetaryValue, productDeserializer.category()
        );
        this.createProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductRequestDTO(newProduct));

    }

    @PutMapping("/product/{sku}/update")
    public ResponseEntity<ProductRequestDTO> updateProductHTTP(@PathVariable String sku, @RequestBody ProductRequestDTO productDeserializer) {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDeserializer.monetaryValue()));
        Product newProduct = new Product(
                productDeserializer.sku(), productDeserializer.name(), productDeserializer.description(), monetaryValue, productDeserializer.category()
        );
        this.updateProduct(sku, newProduct);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ProductRequestDTO(newProduct));
    }

    @PostMapping("/product/{sku}/remove")
    public void deleteProductBySkuHTTP(@PathVariable String sku) {
        this.deleteProduct(sku);
    }

    @Override
    public List<Product> getProducts() {
        return this.productApplication.getProducts();
    }

    @Override
    public Product getProductBySku(String sku) {
        return this.productApplication.getProductBySku(sku);
    }

    @Override
    public Product createProduct(Product product) {
        return this.productApplication.createProduct(product);
    }

    @Override
    public Product updateProduct(String sku, Product product) {
        return this.productApplication.updateProduct(sku, product);
    }

    @Override
    public void deleteProduct(String sku) {
        this.productApplication.deleteProduct(sku);
    }

}
