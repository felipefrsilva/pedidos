package br.com.fiap.techchallange.infrastructure.config.usecase.managementproduct;

import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.*;
import br.com.fiap.techchallange.core.usecase.managementproduct.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementProductUseCaseConfig {
    @Bean
    public IGetProductBySkuUseCase getProductBySkuUseCase(IProductRepository repository) {
        return new GetProductBySkuUseCase(repository);
    }

    @Bean
    public IGetProductListUseCase getProductListUseCase(IProductRepository repository) {
        return new GetProductListUseCase(repository);
    }

    @Bean
    public IRegisterProductUseCase registerProductUseCase(IProductRepository repository) {
        return new RegisterProductUseCase(repository);
    }
    @Bean
    public IRemoveProductUseCase removeProductUseCase(IProductRepository repository) {
        return new RemoveProductUseCase(repository);
    }

    @Bean
    public IUpdateProductUseCase updateProductUseCase(IProductRepository repository) {
        return new UpdateProductUseCase(repository);
    }
}
