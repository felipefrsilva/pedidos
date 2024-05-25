//package br.com.fiap.techchallange.infrastructure.adapters.out.repository;
//import br.com.fiap.techchallange.application.ports.out.repository.IClientRepository;
//import br.com.fiap.techchallange.domain.entity.Client;
//import br.com.fiap.techchallange.domain.vo.CPF;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class MySQLClientRepository implements IClientRepository {
//
//    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    @Autowired
//    public MySQLClientRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
//        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//    }
//
//    public Client getClient(String cpf) {
//        String sql = "SELECT * FROM dbtechchallange.client where cpf = ?";
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("cpf", cpf);
//        return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Client>() {
//            @Override
//            public Client mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
//                return new Client(rs.getObject("cpf", CPF.class),
//                        rs.getString("name"),
//                        rs.getString("email"));
//            }
//        });
//    }
//
//    @Override
//    public void addClient(String cpf, String name, String email) {
//        String sql = "INSERT into dbtechchallange.client (cpf, name, email) VALUES (cpf = ?, name = ?, email = ?)";
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("cpf", cpf);
//        params.addValue("name", name);
//        params.addValue("email", email);
//
//        namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Client>() {
//            @Override
//            public Client mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
//                return new Client(rs.getObject("cpf", CPF.class),
//                        rs.getString("name"),
//                        rs.getString("email"));
//            }
//        });
//    }
//}