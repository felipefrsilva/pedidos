package br.com.fiap.techchallange.infrastructure.ports.out.repository;

import br.com.fiap.techchallange.orders.domain.entity.Client;

public interface IClientRepository {

    public Client getClient(String cpf);
    public Client addClient(String cpf, String name, String email);
}
