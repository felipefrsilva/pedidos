package br.com.fiap.techchallange.domain.service;

public class ManagementClienteService {

    public void registerCliente(String name, String CPF, String email){
        new Client(name, CPF, email);
    }
}
