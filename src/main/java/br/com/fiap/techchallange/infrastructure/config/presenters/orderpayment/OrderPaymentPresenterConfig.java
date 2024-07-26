package br.com.fiap.techchallange.infrastructure.config.presenters.orderpayment;

import br.com.fiap.techchallange.adapters.presenters.orderpayment.OrderPaymentPresenterJson;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.IOrderPaymentPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPaymentPresenterConfig {

    @Bean
    public IOrderPaymentPresenter getOrderPaymentPresenter(){
        return new OrderPaymentPresenterJson();
    }
}
