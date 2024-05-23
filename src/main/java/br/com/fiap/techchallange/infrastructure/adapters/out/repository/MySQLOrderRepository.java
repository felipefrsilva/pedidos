package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IOrderRepository;
import br.com.fiap.techchallange.domain.entity.Order;
import br.com.fiap.techchallange.domain.entity.Product;
import br.com.fiap.techchallange.domain.vo.Item;
import jakarta.persistence.EntityManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Repository
public class MySQLOrderRepository implements IOrderRepository {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MySQLOrderRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Order getOrder(String id) {
        return null;
    }

    @Override
    public void addOrder(Order order) {

    }

    /*
        @Override
        public Order getOrder(String id) {
            String sql = "SELECT * FROM dbtechchallange.order WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Order order = new Order(rs.getLong("id"), );
                order.setId();
                order.setNome(rs.getString("nome"));
                // Defina os outros atributos conforme necessário
                return objeto;
            });
        }
    */
    @Transactional
    @Override
    /*public void addOrder(Order order) {
        entityManager.persist(order);
    }*/


    public void update(Order order) {
        String sql = "UPDATE my_table SET name = ? WHERE id = ?";
    }

    private Map<String, Item> getItems(String ordemId){
        String sql = "SELECT * FROM dbtechchallange.item WHERE id = ?";
      /*
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<SeuObjeto>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item objeto = new Item();
                objeto.setId(rs.getLong("id"));
                objeto.setNome(rs.getString("nome"));
                return objeto;
            }
        });

       */

        return null;
    }

    private Product getProduct(String sku){
        String sql = "SELECT * FROM dbtechchallange.product WHERE id = ?";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", sku);
        return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Product>() {
            @Override
            public Product mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                return new Product(rs.getString("sku"),
                                    rs.getString("name"),
                                    rs.getString("description"),
                                    rs.getFloat("price"),
                                    rs.getString("category") );
            }
        });
    }
}
