package br.com.fiap.techchallange.core.usecase.managementcustomer;

import br.com.fiap.techchallange.core.usecase.dto.managementcustomer.InputDataCustomerDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.managementcustomer.IRemovalOfCustomerUserCase;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;

public class RemovalOfCustomerUserCase implements IRemovalOfCustomerUserCase {

    private final ICustomerRepository repository;

    public RemovalOfCustomerUserCase(ICustomerRepository repository){
        this.repository = repository;
    }

    @Override
    public void invoke(InputDataCustomerDTO inputDataCustomerDTODTO) {
            this.repository.remove(inputDataCustomerDTODTO.getCpf());
    }
}