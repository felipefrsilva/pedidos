package ports.in;

import Domain.Entities.Cliente;

import java.util.List;

public interface ClienteRepository {
    public Cliente cadastrarCliente(Cliente cliente);
    public Cliente buscarCliente(String cpf);
    public void removerCliente(String cpf);
    public List<Cliente> listarClientes();
}
