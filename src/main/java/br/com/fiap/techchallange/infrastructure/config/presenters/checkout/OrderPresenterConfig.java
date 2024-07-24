package br.com.fiap.techchallange.infrastructure.config.presenters.checkout;

import br.com.fiap.techchallange.adapters.presenters.checkout.FinishOrderSelectionPresenter;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.checkout.IFinishOrderSelectionPresenter;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.checkout.IProductPresenter;
import br.com.fiap.techchallange.adapters.presenters.checkout.ProductPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPresenterConfig {

    @Bean
    public IProductPresenter getProductsPresenter(){
        return new ProductPresenter();
    }

    @Bean
    public IFinishOrderSelectionPresenter getFinishOrderSelectionPresenter(){
        return new FinishOrderSelectionPresenter();
    }
}
