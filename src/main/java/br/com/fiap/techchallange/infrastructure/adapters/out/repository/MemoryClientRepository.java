package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.domain.entity.Client;
import br.com.fiap.techchallange.domain.vo.CPF;

import java.util.ArrayList;
import java.util.List;

public class MemoryClientRepository implements IClientRepository {

    private Client client;
    private static MemoryClientRepository instance;

    private final List<Client> clients;
    public MemoryClientRepository() {
        clients = new ArrayList<Client>();

        clients.add(new Client((new CPF("12345678910")), "João das Dores", "joaodasdores@gmail.com"));
        clients.add(new Client((new CPF("12345098910")), "Maria do Socorro", "mariadosocorro@gmail.com"));
        clients.add(new Client((new CPF("09345678910")), "Ju Li Ana", "ju_li_ana@instagram.com"));
        clients.add(new Client((new CPF("89345678910")), "Pé Lé", "peleoficial@gmail.com"));
        clients.add(new Client((new CPF("12349078911")), "Gira Fales", "girafales@chaves.com"));
    }
    public static synchronized MemoryClientRepository getInstance() {
        if (instance == null) {
            instance = new MemoryClientRepository();
        }
        return instance;
    }

    @Override
    public void addClient(String cpf, String name, String email) {
        CPF cpfVo = new CPF(cpf);
        this.clients.add(new Client(cpfVo, name, email));
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

}
