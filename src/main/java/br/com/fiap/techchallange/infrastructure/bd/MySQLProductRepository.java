package br.com.fiap.techchallange.infrastructure.bd;

import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.adapters.gateways.repository.IProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MySQLProductRepository implements IProductRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MySQLProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Product> getProducts() {
        String sql = "SELECT * FROM dbtechchallange.product";
        RowMapper<Product> productRowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getString("sku"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getString("category")
                );
            }
        };
        return namedParameterJdbcTemplate.query(sql, productRowMapper);
    }

    @Override
    public Product getProductBySku(String sku) {
        String sql = "SELECT * FROM dbtechchallange.product WHERE sku = :sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", sku);
        RowMapper<Product> productRowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getString("sku"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getString("category")
                );
            }
        };

        try {
            Product product = namedParameterJdbcTemplate.queryForObject(sql, params, productRowMapper);
            return product;
        } catch (Exception e) {
            System.out.println("Product " + sku + " not found");
            return null;
        }
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        String sql = "SELECT * FROM dbtechchallange.product WHERE category = :category";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("category", category);
        RowMapper<Product> productRowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getString("sku"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getString("category")
                );
            }
        };
        return namedParameterJdbcTemplate.query(sql, params, productRowMapper);
    }

    @Transactional
    @Override
    public void createProduct(Product product) {
        String sql = "" +
                " INSERT INTO dbtechchallange.product (sku, name, description, price, category)" +
                " VALUES (:sku, :name, :description, :price, :category)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", product.getSku());
        params.addValue("name", product.getName());
        params.addValue("description", product.getDescription());
        params.addValue("price", product.getMonetaryValue());
        params.addValue("category", product.getCategory());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Transactional
    @Override
    public void updateProduct(String sku, Product product) {
        String sql = "" +
                " UPDATE dbtechchallange.product" +
                " SET name=:name, description=:description, price=:price, category=:category" +
                " WHERE sku=:sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", sku);
        params.addValue("name", product.getName());
        params.addValue("description", product.getDescription());
        params.addValue("price", product.getMonetaryValue());
        params.addValue("category", product.getCategory());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Transactional
    @Override
    public void deleteProduct(String sku) {
        String sql = "DELETE FROM dbtechchallange.product WHERE sku=:sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", sku);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
