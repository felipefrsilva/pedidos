package br.com.fiap.techchallange.infrastructure.config.usecase.managementcustomer;

import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IChangingCustomerUserCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUserCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUserCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUserCase;
import br.com.fiap.techchallange.core.usecase.managementcustomer.*;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerUserCaseConfig {

    @Bean
    public IGetCustomerUserCase getCustomerUserCase(ICustomerRepository repository){
        return new GetCustomerUserCase(repository);
    }

    @Bean
    public IRegisteringCustomerUserCase registerCustomerUserCase(ICustomerRepository repository){
        return new RegisteringCustomerUserCase(repository);
    }

    @Bean
    public IChangingCustomerUserCase changingCustomerUserCase(ICustomerRepository repository){
        return new ChangingCustomerUserCase(repository);
    }

    @Bean
    public IRemovalOfCustomerUserCase removalOfCustomerUserCase(ICustomerRepository repository){
        return new RemovalOfCustomerUserCase(repository);
    }

}
