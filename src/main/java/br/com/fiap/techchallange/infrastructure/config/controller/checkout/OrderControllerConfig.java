package br.com.fiap.techchallange.infrastructure.config.controller.checkout;

import br.com.fiap.techchallange.adapters.controllers.checkout.IProductsDisplayController;
import br.com.fiap.techchallange.adapters.controllers.checkout.ProductsDisplayController;
import br.com.fiap.techchallange.core.usecase.inputboundary.checkout.IProductsDisplayUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderControllerConfig {

    @Bean
    public IProductsDisplayController getProducts(IProductsDisplayUseCase productsDisplayUseCase){
        return new ProductsDisplayController(productsDisplayUseCase);
    }
}
