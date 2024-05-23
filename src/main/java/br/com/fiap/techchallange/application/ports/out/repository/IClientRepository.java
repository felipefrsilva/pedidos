package br.com.fiap.techchallange.application.ports.out.repository;

public interface IClientRepository {

    public Client getClient(String cpf);
    public void addClient(String cpf, String name, String email);
//    public List<Client> getClients();
}
