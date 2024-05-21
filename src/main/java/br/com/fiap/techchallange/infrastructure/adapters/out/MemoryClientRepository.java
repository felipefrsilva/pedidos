package br.com.fiap.techchallange.infrastructure.adapters.out;

import br.com.fiap.techchallange.infrastructure.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.orders.domain.entity.Client;
import br.com.fiap.techchallange.orders.domain.vo.CPFVo;

public class MemoryClientRepository implements IClientRepository {

    private Client client;
    public MemoryClientRepository() {

    }
    @Override
    public Client addClient(String cpf, String name, String email) {
        CPFVo cpfVo = new CPFVo(cpf);
        return new Client(cpfVo, name, email);
    }

    @Override
    public Client getClient(String cpf) {
        return null;
    }
}
