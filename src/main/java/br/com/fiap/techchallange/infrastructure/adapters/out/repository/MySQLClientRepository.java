package br.com.fiap.techchallange.infrastructure.adapters.out.repository;
import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
import br.com.fiap.techchallange.domain.entity.Client;
import br.com.fiap.techchallange.domain.vo.CPF;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;

@Repository
public class MySQLClientRepository implements IClientRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MySQLClientRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Client getClient(String cpf) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM dbtechchallange.client where cpf = :cpf";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", cpf);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Client>() {
                @Override
                public Client mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                    return new Client(rs.getString("cpf"),
                            rs.getString("name"),
                            rs.getString("email"));
                }
            });
        } catch (EmptyResultDataAccessException e) {
            throw e;
        }
    }

    @Override
    public void addClient(String cpf, String name, String email) throws DataAccessException {
        String sql = "INSERT into dbtechchallange.client (cpf, name, email) VALUES (:cpf, :name, :email)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", cpf);
        params.addValue("name", name);
        params.addValue("email", email);

        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (DataAccessException e) {
            throw e;
        }
    }
}