package br.com.fiap.techchallange.infrastructure.config.controller.managementproduct;

import br.com.fiap.techchallange.adapters.controllers.managementproduct.*;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementproduct.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagementProductControlerConfig {

    @Bean
    IGetProductBySkuController getProductBySkuController(IGetProductBySkuUseCase getProductBySkuUseCase) {
        return new GetProductBySkuController(getProductBySkuUseCase);
    }

    @Bean
    IGetProductListController getProductListController(IGetProductListUseCase getProductListUseCase) {
        return new GetProductListController(getProductListUseCase);
    }

    @Bean
    IRegisterProductController registerProductController(IRegisterProductUseCase registerProductUseCase) {
        return new RegisterProductController(registerProductUseCase);
    }

    @Bean
    IRemoveProductController removeProductController(IRemoveProductUseCase removeProductUseCase) {
        return new RemoveProductController(removeProductUseCase);
    }

    @Bean
    IUpdateProductController updateProductController(IUpdateProductUseCase updateProductUseCase) {
        return new UpdateProductController(updateProductUseCase);
    }
}
