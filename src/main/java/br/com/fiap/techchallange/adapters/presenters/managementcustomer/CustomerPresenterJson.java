package br.com.fiap.techchallange.adapters.presenters.managementcustomer;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.managementcustomer.ICustomerPresenter;

public class CustomerPresenterJson implements ICustomerPresenter {

    @Override
    public CustomerViewModel invoke(OutputDataCustomerDTO customerDTO) {
        return new CustomerViewModel(customerDTO.cpf(), customerDTO.name(), customerDTO.email());
    }
}
