package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;

public class GetCustomerContoller implements IGetCustomerController {

    IGetCustomerUseCase getCustomerUserCase;

    public GetCustomerContoller(IGetCustomerUseCase queryUserCase){
        this.getCustomerUserCase = queryUserCase;
    }

    public OutputDataCustomerDTO invoke(String cpf) {
        InputDataCustomerDTO inputData = new InputDataCustomerDTO(cpf);
        return getCustomerUserCase.get(inputData);
    }
}
