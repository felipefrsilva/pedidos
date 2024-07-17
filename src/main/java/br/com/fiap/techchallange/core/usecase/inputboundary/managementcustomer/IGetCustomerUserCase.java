package br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.OutputDataCustomerDTO;

public interface IGetCustomerUserCase {
    public OutputDataCustomerDTO get(InputDataCustomerDTO inputDataCustomer);
}
