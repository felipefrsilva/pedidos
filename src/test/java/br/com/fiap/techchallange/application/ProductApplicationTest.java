package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.infrastructure.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductApplicationTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductApplication productApplication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getProductsReturnsListOfProducts() {

        when(productRepository.getProducts()).thenReturn(Arrays.asList(
                new Product("A001", "Test Burger", "My test item", new MonetaryValue(new BigDecimal("1.78"), "BRL"), "test"),
                new Product("A002", "Test ice cream", "My test item", new MonetaryValue(new BigDecimal("1.78"), "BRL"), "test")
        ));
        List<Product> products = productApplication.getProducts();
        assertEquals(2, products.size());
    }

    @Test
    void getProductsReturnsEmptyIfThereAreNoProducts() {
        List<Product> emptyList = List.of();
        when(productRepository.getProducts()).thenReturn(emptyList);
        List<Product> products = productApplication.getProducts();
        assertEquals(0, products.size());
    }

    @Test
    void getProductBySkuReturnsProduct() {
        Product mockProduct = new Product("A001", "Test Burger", "My test item", new MonetaryValue(new BigDecimal("1.78"), "BRL"), "test");
        when(productRepository.getProductBySku("A001")).thenReturn(mockProduct);
        Product product = productApplication.getProductBySku("A001");
        assertEquals(mockProduct, product);
    }

//    @Test
//    void getProductBySkuThrowsExceptionWhenProductNotFound() {
//        when(productRepository.getProductBySku("A001")).thenReturn(null);
//        assertThrows(RuntimeException.class, () -> productApplication.getProductBySku("A001"));
//    }

    @Test
    void createProductReturnsCreatedProduct() {
        Product product = new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a");
        when(productRepository.createProduct(product)).thenReturn(product);
        Product createdProduct = productApplication.createProduct(product);
        assertEquals(product, createdProduct);
    }

//    @Test
//    void createProductThrowsExceptionWhenProductAlreadyExists() {
//
//    }

    @Test
    void updateProductReturnsUpdatedProduct() {
        Product product = new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a");
        when(productRepository.updateProduct("A001", product)).thenReturn(product);
        Product updatedProduct = productApplication.updateProduct("A001", product);
        assertEquals(product, updatedProduct);
    }

//    @Test
//    void updateProductThrowsExceptionWhenProductNotFound() {
//        Product product = new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a");
//        when(productRepository.updateProduct("A001", product)).thenReturn(product);
//        assertThrows(RuntimeException.class, () -> productApplication.updateProduct("A001", product));
//    }

    @Test
    void deleteProductDeletesProduct() {
        doNothing().when(productRepository).deleteProduct("A001");
        productApplication.deleteProduct("A001");
        verify(productRepository, times(1)).deleteProduct("A001");
    }

//    @Test
//    void deleteProductThrowsExceptionWhenProductNotFound() {
//
//    }
}