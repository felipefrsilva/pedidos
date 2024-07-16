package br.com.fiap.techchallange.adapters.gateways.repository;

import br.com.fiap.techchallange.core.entity.Customer;

public interface ICustomerRepository {

    public Customer getCustomer(String cpf);
    public void register(Customer customer) throws IllegalArgumentException;
    public void changing(Customer customer);
    public void remove(String cpf);
}
