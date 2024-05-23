package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.domain.entity.Client;
import br.com.fiap.techchallange.orders.domain.entity.Product;

public interface ClientManagement {
        public void addClient(String cpf, String name, String email);
        public Client getClient(String cpf);
//        public List<Client> getClients();
}
