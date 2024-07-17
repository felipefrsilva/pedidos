package br.com.fiap.techchallange.infrastructure.config.presenters.managementcustomer;

import br.com.fiap.techchallange.adapters.presenters.managementcustomer.CustomerResponsePresenterJson;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.ICustomerPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerPresenterConfig {

    @Bean
    public ICustomerPresenter getCustomerPresenter(){
        return new CustomerResponsePresenterJson();
    }
}
