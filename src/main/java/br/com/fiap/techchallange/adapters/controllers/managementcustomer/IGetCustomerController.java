package br.com.fiap.techchallange.adapters.controllers.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;

public interface IGetCustomerController {
    public OutputDataCustomerDTO invoke(String cpf);
}
