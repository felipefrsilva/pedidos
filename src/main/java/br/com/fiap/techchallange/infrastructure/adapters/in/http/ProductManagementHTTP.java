package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.usecases.ProductApplication;
import br.com.fiap.techchallange.application.ports.in.http.IProductManagement;
import br.com.fiap.techchallange.domain.entity.Product;
import br.com.fiap.techchallange.domain.vo.MonetaryValue;
import br.com.fiap.techchallange.infrastructure.factory.FactoryProductApplication;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("v1/products")
@Tag(name="2. Product Management", description = "Endpoints para gerenciamento de produtos")
public class ProductManagementHTTP implements IProductManagement {

    private ProductApplication productApplication;

    @Autowired
    public void setFactory(FactoryProductApplication factory) {
        this.productApplication = factory.createProductApplication();
    }


    @ExceptionHandler
    public ResponseEntity<String> handleException(@NotNull Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @GetMapping("/list")
    @Operation(summary = "Lista todos os produtos cadastrados")
    public ResponseEntity<List<ProductRequestDTO>> getProductsHTTP() {
        List<Product> productList = this.getProducts();
        List<ProductRequestDTO> response;
        response = productList.stream().map((product) -> new ProductRequestDTO(product)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/list/category/{category}")
    @Operation(summary = "Lista todos os produtos cadastrados de uma categoria")
    public ResponseEntity<List<ProductRequestDTO>> getProductsByCategoryHTTP(@PathVariable String category) {
        List<Product> productList = this.getProductsByCategory(category);
        List<ProductRequestDTO> response;
        response = productList.stream().map((product) -> new ProductRequestDTO(product)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{sku}")
    @Operation(summary = "Consulta um produto pelo SKU")
    public ResponseEntity<ProductRequestDTO> getProductBySkuHTTP(@PathVariable String sku) {
        Product product = this.getProductBySku(sku);

        // Product does not exists
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ProductRequestDTO response = new ProductRequestDTO(product);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    @Operation(summary = "Cria um novo produto")
    public ResponseEntity<ProductRequestDTO> createProductHTTP(@RequestBody ProductRequestDTO productDTO) {

        // Product already exists
        if (this.getProductBySku(productDTO.sku()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDTO.monetaryValue()));
        Product newProduct = new Product(
                productDTO.sku(), productDTO.name(), productDTO.description(), monetaryValue.getValue(), productDTO.category()
        );
        this.createProduct(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductRequestDTO(newProduct));

    }

    @PutMapping("/update")
    @Operation(summary = "Atualiza um produto")
    public ResponseEntity<ProductRequestDTO> updateProductHTTP(@RequestBody ProductRequestDTO productDTO) {

        // Product does not exits
        if (this.getProductBySku(productDTO.sku()) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDTO.monetaryValue()));
        Product newProduct =new Product(
                    productDTO.sku(), productDTO.name(), productDTO.description(), monetaryValue.getValue(), productDTO.category()
            );
        this.updateProduct(productDTO.sku(), newProduct);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ProductRequestDTO(newProduct));
    }

    @DeleteMapping("/{sku}")
    @Operation(summary = "Remove um produto pelo SKU")
    public ResponseEntity<Object> deleteProductBySkuHTTP(@PathVariable String sku) {
        // Product does not exits
        if (this.getProductBySku(sku) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        this.deleteProduct(sku);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
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
    public List<Product> getProductsByCategory(String category) {
        return this.productApplication.getProductsByCategory(category);
    }

    @Override
    public void createProduct(Product product) {
        this.productApplication.createProduct(product);
    }

    @Override
    public void updateProduct(String sku, Product product) {
        this.productApplication.updateProduct(sku, product);
    }

    @Override
    public void deleteProduct(String sku) {
        this.productApplication.deleteProduct(sku);
    }

}
