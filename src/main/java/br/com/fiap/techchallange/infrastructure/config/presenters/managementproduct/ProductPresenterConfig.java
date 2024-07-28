package br.com.fiap.techchallange.infrastructure.config.presenters.managementproduct;

import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.managementproduct.IProductManagementPresenter;
import br.com.fiap.techchallange.adapters.presenters.managementproduct.ProductManagementPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductPresenterConfig {

    @Bean
    public IProductManagementPresenter getProductManagementPresenter(){
        return new ProductManagementPresenter();
    }
}
