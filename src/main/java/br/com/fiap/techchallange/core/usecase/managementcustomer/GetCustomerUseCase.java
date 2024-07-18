package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.entity.Customer;
import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IGetCustomerUseCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class GetCustomerUseCase implements IGetCustomerUseCase {

    private final ICustomerRepository repository;

    public GetCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public OutputDataCustomerDTO get(InputDataCustomerDTO inputDataCustomer) {
        Customer customer = repository.getCustomer(inputDataCustomer.cpf());
        return new OutputDataCustomerDTO(customer.getCPF(), customer.getName(), customer.getEmail());
    }
}
