package br.com.fiap.techchallange.adapters.presenters.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.ICustomerPresenter;

public class CustomerResponsePresenterJson implements ICustomerPresenter {

    @Override
    public CustomerResponseModel present(OutputDataCustomerDTO customerDTO) {
        return new CustomerResponseModel(customerDTO);
    }
}
