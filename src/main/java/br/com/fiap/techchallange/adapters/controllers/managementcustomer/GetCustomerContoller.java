package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUserCase;

public class GetCustomerContoller implements IGetCustomerController {

    IGetCustomerUserCase queryUserCase;

    public GetCustomerContoller(IGetCustomerUserCase queryUserCase){
        this.queryUserCase = queryUserCase;
    }

    public OutputDataCustomerDTO getCustomer(String cpf) {
        InputDataCustomerDTO inputData = new InputDataCustomerDTO(cpf);
        return queryUserCase.get(inputData);
    }
}
