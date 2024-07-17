package br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;

public interface IChangingCustomerUserCase {
    public void invoke(InputDataCustomerDTO customerDTO);
}
