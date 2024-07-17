package br.com.fiap.techchallange.infrastructure.config.usecase.ordercreation;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IProductsDisplayUseCase;
import br.com.fiap.techchallange.core.usecase.ordercreation.ProductsDisplayUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderUserCaseConfig {

    @Bean
    public IProductsDisplayUseCase getProductsUseCase(IProductRepository productRepository){
        return new ProductsDisplayUseCase(productRepository);
    }
}
