package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUserCase;

public class RegisterCustomerController implements IRegisterCustomerController {

    IRegisteringCustomerUserCase registeringCustomerUserCase;

    public RegisterCustomerController(IRegisteringCustomerUserCase commandUserCase){
        this.registeringCustomerUserCase = commandUserCase;
    }

    public void registerCustomer(String cpf, String name, String email) {
        registeringCustomerUserCase.invoke(new InputDataCustomerDTO(cpf, name, email));
    }

}
