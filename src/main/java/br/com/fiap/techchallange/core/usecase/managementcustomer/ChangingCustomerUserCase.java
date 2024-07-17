package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.entity.Customer;
import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IChangingCustomerUserCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class ChangingCustomerUserCase implements IChangingCustomerUserCase {

    private final ICustomerRepository repository;

    public ChangingCustomerUserCase(ICustomerRepository repository){
        this.repository = repository;
    }

    public void invoke(InputDataCustomerDTO customerDTO) throws IllegalArgumentException {
        this.repository.changing(new Customer(customerDTO.getCpf(), customerDTO.getName(), customerDTO.getEmail()));
    }
}
