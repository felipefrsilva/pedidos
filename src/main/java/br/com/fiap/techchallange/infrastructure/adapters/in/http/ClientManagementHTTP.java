package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.infrastructure.factory.FactoryClientApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ClientManagement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/clients")
@Tag(name = "2. Service Client", description = "Endpoints de registro e busca de clientes por CPF")
public class ClientManagementHTTP implements ClientManagement {
    private ClientApplication clientApplication;
    FactoryClientApplication factory;

    @Autowired
    public void setFactory(FactoryClientApplication factory) {
        this.factory = factory;
        this.clientApplication = factory.createClientApplication();
    }

    @Operation(summary = "Cria o usuário na base de dados. CPF deve ser apenas números!")
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> addClientHTTP(@RequestBody ClientRequestDTO clientDeserializer) throws DataAccessException {
        Map<String, String> response = new HashMap<>();
        try {
            this.addClient(clientDeserializer.cpf(), clientDeserializer.name(), clientDeserializer.email());
        } catch (DataAccessException e) {
            response.put("status", "CPF já cadastrado na base de dados!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            response.put("status", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        response.put("status", "Cliente cadastrado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public void addClient(String cpf, String name, String email) throws DataAccessException, IllegalArgumentException {
        this.clientApplication.addCLient(cpf, name, email);
    }

    @Override
    @Operation(summary = "Busca o usuário pelo CPF na base de dados. Deve conter apenas números!")
    @GetMapping("/{cpf}")
    public ResponseEntity getClient(@PathVariable String cpf) throws EmptyResultDataAccessException {
        Map<String, String> response = new HashMap<>();
        try {
            return new ResponseEntity<>(this.clientApplication.getClient(cpf), HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            response.put("status", "Cliente não encontrado na base de dados");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
