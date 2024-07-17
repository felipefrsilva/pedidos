package br.com.fiap.techchallange.infrastructure.config.presenters.ordercreation;

import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.IProductPresenter;
import br.com.fiap.techchallange.adapters.presenters.ordercreation.ProductPresenterJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPresenterConfig {

    @Bean
    public IProductPresenter getProductsPresenter(){
        return new ProductPresenterJson();
    }
}
