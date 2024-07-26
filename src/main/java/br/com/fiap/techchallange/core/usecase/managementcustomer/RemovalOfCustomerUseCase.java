package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.customer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUseCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class RemovalOfCustomerUseCase implements IRemovalOfCustomerUseCase {

    private final ICustomerRepository repository;

    public RemovalOfCustomerUseCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public void invoke(InputDataCustomerDTO inputDataCustomerDTODTO) {
            this.repository.remove(inputDataCustomerDTODTO.cpf());
    }
}