package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.OutputDataCustomerDTO;

public interface IGetCustomerController {
    public OutputDataCustomerDTO getCustomer(String cpf);
}
