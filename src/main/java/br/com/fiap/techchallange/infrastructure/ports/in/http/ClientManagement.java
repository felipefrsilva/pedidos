package br.com.fiap.techchallange.infrastructure.ports.in.http;

import org.springframework.http.ResponseEntity;

import java.sql.SQLIntegrityConstraintViolationException;

public interface ClientManagement {
        public void addClient(String cpf, String name, String email) throws SQLIntegrityConstraintViolationException;
        public ResponseEntity getClient(String cpf);
}
