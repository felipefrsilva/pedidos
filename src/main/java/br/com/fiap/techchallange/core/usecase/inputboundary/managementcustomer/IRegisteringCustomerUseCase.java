package br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;

public interface IRegisteringCustomerUseCase {

    public void invoke(InputDataCustomerDTO customerDTO);
}
