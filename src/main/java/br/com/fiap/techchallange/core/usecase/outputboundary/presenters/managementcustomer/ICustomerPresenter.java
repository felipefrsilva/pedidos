package br.com.fiap.techchallange.core.usecase.outputboundary.presenters.managementcustomer;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.CustomerViewModel;
import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;

public interface ICustomerPresenter {
    CustomerViewModel invoke(OutputDataCustomerDTO customerDTO);
}
