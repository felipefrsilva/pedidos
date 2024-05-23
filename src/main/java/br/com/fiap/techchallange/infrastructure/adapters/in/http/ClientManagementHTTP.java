package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ClientManagement;
import br.com.fiap.techchallange.domain.entity.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientManagementHTTP implements ClientManagement {
    private final ClientApplication clientApplication;

    public ClientManagementHTTP() {
         clientApplication = new ClientApplication();
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
    public Client getClient(String cpf) {
        return this.clientApplication.getClient(cpf);
    }

}
