package br.com.fiap.techchallange.infrastructure.api;


import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IGetCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IRegisterCustomerController;
import br.com.fiap.techchallange.infrastructure.dto.ClientRequestDTO;

import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.ICustomerPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clients")
@Tag(name = "2. Service Customer", description = "Endpoints para a Gestão do cadastro do cliente")
public class ManagementCustomer  {
    IRegisterCustomerController registerController;
    IGetCustomerController getController;
    ICustomerPresenter customerPresenterJson;

    public ManagementCustomer(IRegisterCustomerController registerController,
                              IGetCustomerController getController,
                              ICustomerPresenter customerPresenterJson){
        this.registerController = registerController;
        this.getController = getController;
        this.customerPresenterJson = customerPresenterJson;
    }

    @Operation(summary = "Cria o usuário na base de dados. CPF deve ser apenas números!")
    @PostMapping("/create")
    public ResponseEntity<?> registerCustomer(@RequestBody ClientRequestDTO clientDeserializer) throws DataAccessException {
        try {
            this.registerController.registerCustomer(clientDeserializer.cpf(), clientDeserializer.name(), clientDeserializer.email());
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("CPF já cadastrado na base de dados!"), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel(e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( "Cliente cadastrado com sucesso!", HttpStatus.OK);
    }

    @Operation(summary = "Busca o usuário pelo CPF na base de dados. Deve conter apenas números!")
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getCustomer(@PathVariable String cpf) throws EmptyResultDataAccessException {
        try {
            ICustomerPresenter.CustomerResponseModel response = customerPresenterJson.present(this.getController.getCustomer(cpf));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("Cliente não encontrado na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

}
