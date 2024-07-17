package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.entity.Customer;
import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUserCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class GetCustomerUserCase implements IGetCustomerUserCase {

    private final ICustomerRepository repository;

    public GetCustomerUserCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public OutputDataCustomerDTO get(InputDataCustomerDTO inputDataCustomer) {
        Customer customer = repository.getCustomer(inputDataCustomer.getCpf());
        return new OutputDataCustomerDTO(customer.getCPF(), customer.getName(), customer.getEmail());
    }
}
