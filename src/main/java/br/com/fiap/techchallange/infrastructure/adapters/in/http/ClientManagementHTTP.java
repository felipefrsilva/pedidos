package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.application.dto.ClientDTO;
import br.com.fiap.techchallange.infrastructure.factory.FactoryClientApplication;
import br.com.fiap.techchallange.infrastructure.factory.FactoryOrderApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ClientManagement;
import br.com.fiap.techchallange.domain.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Map<String, String>> addClientHTTP(@RequestBody ClientRequestDTO clientDeserializer) {
        this.addClient(clientDeserializer.cpf(), clientDeserializer.name(), clientDeserializer.email());

        Map<String, String> response = new HashMap<>();
        response.put("status", "Cliente cadastrado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public void addClient(String cpf, String name, String email) {
        this.clientApplication.addCLient(cpf, name, email);
    }

    @Override
    public ClientDTO getClient(String cpf) {
        return this.clientApplication.getClient(cpf);
    }

}
