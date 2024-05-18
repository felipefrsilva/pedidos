package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.ProductApplication;
import br.com.fiap.techchallange.infrastructure.adapters.out.exception.MemorySkuAlreadyExists;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductManagementHTTPTest {

    @Mock
    private ProductApplication productApplication;

    @InjectMocks
    private ProductManagementHTTP productManagementHTTP;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productManagementHTTP).build();
    }

    @Test
    public void getProductsReturnsListOfProducts() throws Exception {
        when(productApplication.getProducts()).thenReturn(Arrays.asList(
                new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a"),
                new Product("A001", "test-b", "test-b product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-b")
            )
        );
        mockMvc.perform(get("/products/product/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getProductBySkuReturnsProduct() throws Exception {
        when(productApplication.getProductBySku("A001")).thenReturn(
                new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a")
        );
        mockMvc.perform(get("/products/product/A001")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createProductReturnsCreatedProduct() throws Exception {
        ProductRequest productRequest = new ProductRequest("A001", "test-a", "test-a product", 1.22, "cat-a");
        when(productApplication.createProduct(productRequest)).thenReturn(
                new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a")
        );
        mockMvc.perform(post("/products/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void createExistingProductThrowsException() throws Exception {
        ProductRequest productRequest = new ProductRequest("A001", "test-a", "test-a product", 1.22, "cat-a");
        when(productApplication.createProduct(productRequest)).thenThrow(
                new MemorySkuAlreadyExists("A001")
        );
        mockMvc.perform(post("/products/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateProductReturnsUpdatedProduct() throws Exception {
        ProductRequest productRequest = new ProductRequest("A001", "test-a", "test-a product", 1.22, "cat-a");
        when(productApplication.updateProduct("A001", productRequest)).thenReturn(
                new Product("A001", "test-a", "test-a product", new MonetaryValue(BigDecimal.valueOf(1.22)), "cat-a")
        );
        mockMvc.perform(put("/products/product/A001/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProductBySkuReturnsNoContent() throws Exception {
        mockMvc.perform(post("/products/product/A001/remove")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}