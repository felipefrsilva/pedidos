package br.com.fiap.techchallange.application.ports.out.repository;

import br.com.fiap.techchallange.domain.entity.Client;

public interface IClientRepository {

    public Client getClient(String cpf);
    public void addClient(String cpf, String name, String email);
}
