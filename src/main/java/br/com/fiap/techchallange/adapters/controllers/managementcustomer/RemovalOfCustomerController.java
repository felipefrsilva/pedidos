package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUseCase;

public class RemovalOfCustomerController implements IRemovalOfCustomerController {

    IRemovalOfCustomerUseCase removalOfCustomerUserCase;

    public RemovalOfCustomerController(IRemovalOfCustomerUseCase commandUserCase){
        this.removalOfCustomerUserCase = commandUserCase;
    }

    public void invoke(String cpf) {
        InputDataCustomerDTO inputData = new InputDataCustomerDTO(cpf);
        removalOfCustomerUserCase.invoke(inputData);
    }
}
