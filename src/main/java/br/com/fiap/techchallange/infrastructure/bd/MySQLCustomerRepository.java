package br.com.fiap.techchallange.infrastructure.bd;
import br.com.fiap.techchallange.core.entity.Customer;
import br.com.fiap.techchallange.adapters.gateways.repository.ICustomerRepository;
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

@Repository
public class MySQLCustomerRepository implements ICustomerRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MySQLCustomerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Customer getCustomer(String cpf) throws EmptyResultDataAccessException {
        String sql = "SELECT * FROM dbtechchallange.customer where cpf = :cpf";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", cpf);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Customer>() {
                @Override
                public Customer mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                    return new Customer(rs.getString("cpf"),
                            rs.getString("name"),
                            rs.getString("email"));
                }
            });
        } catch (EmptyResultDataAccessException e) {
            throw e;
        }
    }

    @Override
    public void register(Customer customer) throws DataAccessException {
        String sql = "INSERT into dbtechchallange.customer (cpf, name, email) VALUES (:cpf, :name, :email)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", customer.getCPF());
        params.addValue("name", customer.getName());
        params.addValue("email", customer.getEmail());

        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    @Override
    public void changing(Customer customer) {
        String sql = "UPDATE dbtechchallange.customer set name= :name, email= :email where cpf = :cpf";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", customer.getCPF());
        params.addValue("name", customer.getName());
        params.addValue("email", customer.getEmail());

        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    @Override
    public void remove(String cpf) {
        String sql = "DELETE from dbtechchallange.customer where cpf = :cpf";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("cpf", cpf);

        try {
            namedParameterJdbcTemplate.update(sql, params);
        } catch (DataAccessException e) {
            throw e;
        }
    }
}