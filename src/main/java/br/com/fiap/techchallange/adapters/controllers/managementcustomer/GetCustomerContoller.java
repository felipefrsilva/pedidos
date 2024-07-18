package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUserCase;

public class GetCustomerContoller implements IGetCustomerController {

    IGetCustomerUserCase getCustomerUserCase;

    public GetCustomerContoller(IGetCustomerUserCase queryUserCase){
        this.getCustomerUserCase = queryUserCase;
    }

    public OutputDataCustomerDTO getCustomer(String cpf) {
        InputDataCustomerDTO inputData = new InputDataCustomerDTO(cpf);
        return getCustomerUserCase.get(inputData);
    }
}
