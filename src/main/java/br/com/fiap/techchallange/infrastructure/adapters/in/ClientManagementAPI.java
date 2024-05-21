package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ClientManagement;
import br.com.fiap.techchallange.orders.domain.entity.Client;
import lombok.extern.flogger.Flogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientManagementAPI implements ClientManagement {
    private final ClientApplication clientApplication;

    public ClientManagementAPI() {
         clientApplication = new ClientApplication();
    }

    @Override
    @PostMapping("/add")
    public Client addClient(String cpf, String name, String email) {
        return clientApplication.addCLient(cpf, name, email);
    }

}
