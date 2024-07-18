package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IChangingCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IGetCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IRegisterCustomerController;
import br.com.fiap.techchallange.adapters.controllers.managementcustomer.IRemovalOfCustomerController;
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
@RequestMapping("/v1/customers")
@Tag(name = "2. Service Customer", description = "Endpoints para a Gestão do cadastro do cliente")
public class ManagementCustomer  {
    IRegisterCustomerController registerController;
    IGetCustomerController getController;
    IChangingCustomerController changingController;
    IRemovalOfCustomerController removeController;
    ICustomerPresenter customerPresenterJson;

    public ManagementCustomer(IRegisterCustomerController registerController,
                              IGetCustomerController getController,
                              ICustomerPresenter customerPresenterJson,
                              IChangingCustomerController changingController,
                              IRemovalOfCustomerController removeController
                              ){
        this.registerController = registerController;
        this.getController = getController;
        this.changingController = changingController;
        this.removeController = removeController;
        this.customerPresenterJson = customerPresenterJson;
    }

    @Operation(summary = "Registrar as informações do cliente.")
    @PostMapping("/")
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

    @Operation(summary = "Busca as informações do cliente.")
    @GetMapping("/{cpf}")
    public ResponseEntity<?> getCustomer(@PathVariable String cpf) throws EmptyResultDataAccessException {
        try {
            ICustomerPresenter.CustomerResponseModel response = customerPresenterJson.present(this.getController.getCustomer(cpf));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("Cliente não encontrado na base de dados"), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Atualiza as informações do cliente.")
    @PutMapping("/")
    public ResponseEntity<?> changingCustomer(@RequestBody ClientRequestDTO clientDeserializer) throws DataAccessException {
        try {
            this.changingController.changingCustomer(clientDeserializer.cpf(), clientDeserializer.name(), clientDeserializer.email());
        } catch (DataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("Houve um problema na atualização das informações do cliente"), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel(e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( "Cliente atualizado com sucesso!", HttpStatus.OK);
    }

    @Operation(summary = "Remove as informações do cliente.!")
    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> removceCustomer(@PathVariable String cpf) throws EmptyResultDataAccessException {
        try {
            this.removeController.RemoveCustomer(cpf);
            return new ResponseEntity<>("Dados do cliente removido com sucesso.", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(new ICustomerPresenter.ErrorResponseModel("Houve um problema na remoção das informações do cliente."), HttpStatus.NOT_FOUND);
        }
    }

}
