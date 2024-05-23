package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.orders.domain.entity.Client;
import br.com.fiap.techchallange.orders.domain.entity.Product;

import java.util.List;

public interface ClientManagement {
        public void addClient(String cpf, String name, String email);
        public Client getClient(String cpf);
//        public List<Client> getClients();
}
