package br.com.fiap.techchallange.infrastructure.config.controller.managementcustomer;

import br.com.fiap.techchallange.adapters.controllers.managementcustomer.*;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IChangingCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IGetCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IRegisterCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IRemovalOfCustomerController;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IChangingCustomerUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUseCase;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerControllerConfig {

    @Bean
    public IGetCustomerController getCustomerController(IGetCustomerUseCase getCustomerUserCase){
        return new GetCustomerContoller(getCustomerUserCase);
    }

    @Bean
    public IRegisterCustomerController getRegisterCustomerController(IRegisteringCustomerUseCase registerCustomerUserCase){
        return new RegisterCustomerController(registerCustomerUserCase);
    }

    @Bean
    public IChangingCustomerController getChangingCustomer(IChangingCustomerUseCase changingCustomerUserCase){
        return new ChangingCustomerController(changingCustomerUserCase);
    }

    @Bean
    public IRemovalOfCustomerController getRemovalCustomerController(IRemovalOfCustomerUseCase removalOfCustomerUserCase){
        return new RemovalOfCustomerController(removalOfCustomerUserCase);
    }
}
