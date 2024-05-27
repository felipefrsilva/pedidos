package br.com.fiap.techchallange.infrastructure.ports.in.http;

import br.com.fiap.techchallange.application.dto.ClientDTO;

import java.sql.SQLIntegrityConstraintViolationException;

public interface ClientManagement {
        public void addClient(String cpf, String name, String email) throws SQLIntegrityConstraintViolationException;
        public ClientDTO getClient(String cpf);
}
