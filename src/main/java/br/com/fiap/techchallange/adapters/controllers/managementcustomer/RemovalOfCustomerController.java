package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUserCase;

public class RemovalOfCustomerController implements IRemovalOfCustomerController {

    IRemovalOfCustomerUserCase removalOfCustomerUserCase;

    public RemovalOfCustomerController(IRemovalOfCustomerUserCase commandUserCase){
        this.removalOfCustomerUserCase = commandUserCase;
    }

    public void RemoveCustomer(String cpf) {
        InputDataCustomerDTO inputData = new InputDataCustomerDTO(cpf);
        removalOfCustomerUserCase.invoke(inputData);
    }
}
