package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IChangingCustomerUserCase;

public class ChangingCustomerController implements IChangingCustomerController {

    IChangingCustomerUserCase changingCustomerUserCase;

    public ChangingCustomerController(IChangingCustomerUserCase commandUserCase){
        this.changingCustomerUserCase = commandUserCase;
    }

    public void changingCustomer(String cpf, String name, String email) {
        changingCustomerUserCase.invoke(new InputDataCustomerDTO(cpf, name, email));
    }
}
