package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.entity.Customer;
import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRegisteringCustomerUserCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class RegisteringCustomerUserCase implements IRegisteringCustomerUserCase {

    private final ICustomerRepository repository;

    public RegisteringCustomerUserCase(ICustomerRepository repository){
        this.repository = repository;
    }

    public void invoke(InputDataCustomerDTO customerDTO) throws IllegalArgumentException {
        this.repository.register(new Customer(customerDTO.getCpf(), customerDTO.getName(), customerDTO.getEmail()));
    }

}
