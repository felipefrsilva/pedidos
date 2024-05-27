package br.com.fiap.techchallange.application;

import br.com.fiap.techchallange.application.dto.ClientDTO;
import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.domain.entity.Client;
import br.com.fiap.techchallange.domain.vo.CPF;
import br.com.fiap.techchallange.domain.vo.Email;
import br.com.fiap.techchallange.domain.vo.Name;
import org.springframework.dao.DataAccessException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;

public class ClientApplication {
    IClientRepository repository;

    public ClientApplication(IClientRepository repository) {
        this.repository = repository;
    }

    public void addCLient(String cpf, String name, String email) throws DataAccessException, IllegalArgumentException {
        CPF cpfVO = new CPF(cpf);
        Name nameVO = new Name(name);
        Email emailVO = new Email(email);
        this.repository.addClient(cpfVO.getCpfValue(), nameVO.getNameValue(), emailVO.getEmailValue());
    }

    public ClientDTO getClient(String cpf) {
        // Get Client from DataBase
        Client client = this.repository.getClient(cpf);

        // Build Client DTO to return
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setCpf(client.getCPF());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());

        return clientDTO;
    }

}
