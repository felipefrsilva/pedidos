package br.com.fiap.techchallange.infrastructure.adapters.out;

import br.com.fiap.techchallange.infrastructure.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.orders.domain.entity.Client;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.CPF;

import java.util.ArrayList;
import java.util.List;

public class MemoryClientRepository implements IClientRepository {

    private Client client;

    private final List<Client> clients;
    public MemoryClientRepository() {
        clients = new ArrayList<Client>();

        clients.add(new Client((new CPF("12345678910")), "João das Dores", "joaodasdores@gmail.com"));
        clients.add(new Client((new CPF("12345098910")), "Maria do Socorro", "mariadosocorro@gmail.com"));
        clients.add(new Client((new CPF("09345678910")), "Ju Li Ana", "ju_li_ana@instagram.com"));
        clients.add(new Client((new CPF("89345678910")), "Pé Lé", "peleoficial@gmail.com"));
        clients.add(new Client((new CPF("12349078911")), "Gira Fales", "girafales@chaves.com"));
    }
    @Override
    public Client addClient(String cpf, String name, String email) {
        CPF cpfVo = new CPF(cpf);
        return new Client(cpfVo, name, email);
    }

    @Override
    public Client getClient(String cpf) {
        for (Client value : this.clients) {
            CPF cpfVO = new CPF(cpf);
            if (cpfVO.equals(value.cpf)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Client> getClients() {
        return this.clients;
    }

}
