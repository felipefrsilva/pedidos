package br.com.fiap.techchallange.infrastructure.adapters.out;

import br.com.fiap.techchallange.domain.entity.Product;
import br.com.fiap.techchallange.domain.vo.MonetaryValue;
import br.com.fiap.techchallange.infrastructure.adapters.out.repository.MemoryProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRepositoryTest {

    MemoryProductRepository memoryProductRepository;
    @BeforeEach
    void setUp() {
        List<Product> _productList = new ArrayList<>();

        _productList.add(
                new Product(
                        "T001"
                        , "Test Burger"
                        , "My test item"
                        , new MonetaryValue(new BigDecimal("1.78")).getValue()
                        , "test"
                )
        );

        _productList.add(
                new Product(
                        "T002"
                        , "Test Drink"
                        , "My test item"
                        , new MonetaryValue(new BigDecimal("1.78")).getValue()
                        , "test"
                )
        );

        this.memoryProductRepository = new MemoryProductRepository(_productList);
    }

    @Test
    void createProductReturnsCreatedProduct() {
       /* MonetaryValue productPrice = new MonetaryValue(new BigDecimal("1.78"));
        Product product = new Product("T003", "Test ice cream", "My test item", productPrice.getValue(), "test");

       // Product addedProduct = this.memoryProductRepository.createProduct(product);

        assertNotNull(addedProduct);
        assertEquals("T003", addedProduct.getSku());*/
    }

    @Test
    void getProductsReturnProductList() {
        List<Product> productList = this.memoryProductRepository.getProducts();
        assertNotNull(productList);
        assertEquals(2, productList.size());
    }

    @Test
    void getProductBySkuReturnsRequestedProduct() {
        Product product = this.memoryProductRepository.getProductBySku("T001");
        assertNotNull(product);
        assertEquals("T001", product.getSku());
    }


    @Test
    void updateProductModifiesProductAttributes() {
      /*  MonetaryValue productPrice = new MonetaryValue(new BigDecimal("1.78"));
        Product _product = new Product("T002", "Test ice cream", "My new description", productPrice.getValue(), "test");
        Product product = this.memoryProductRepository.updateProduct(_product.getSku(), _product);
        assertNotNull(product);
        assertEquals("T002", product.getSku());
        assertEquals("My new description", product.getDescription());*/
    }

    @Test
    void deleteProductRemovesProductFromList() {
        this.memoryProductRepository.deleteProduct("T001");
        assertNull(this.memoryProductRepository.getProductBySku("T001"));
    }
}