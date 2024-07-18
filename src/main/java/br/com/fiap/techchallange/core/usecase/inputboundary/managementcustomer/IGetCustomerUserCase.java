package br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;

public interface IGetCustomerUserCase {
    public OutputDataCustomerDTO get(InputDataCustomerDTO inputDataCustomer);
}
