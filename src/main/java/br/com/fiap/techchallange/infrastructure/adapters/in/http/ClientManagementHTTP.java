package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.application.dto.ClientDTO;
import br.com.fiap.techchallange.infrastructure.factory.FactoryClientApplication;
import br.com.fiap.techchallange.infrastructure.factory.FactoryOrderApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ClientManagement;
import br.com.fiap.techchallange.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientManagementHTTP implements ClientManagement {
    private ClientApplication clientApplication;
    FactoryClientApplication factory;

    @Autowired
    public void setFactory(FactoryClientApplication factory) {
        this.factory = factory;
        this.clientApplication = factory.createClientApplication();
    }

    @PostMapping("/client/add")
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
    @GetMapping("/client")
    public ClientDTO getClient(String cpf) {
        try {
            return this.clientApplication.getClient(cpf);
        } catch (Exception e) {
            throw e;
        }
    }

}
