package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IProductRepository;
import br.com.fiap.techchallange.domain.entity.Product;
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
        String sql = "SELECT * FROM RestauranteFiap.product";
        RowMapper<Product> productRowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getString("sku"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("monetaryValue"),
                        rs.getString("category")
                );
            }
        };
        return namedParameterJdbcTemplate.query(sql, productRowMapper);
    }

    @Override
    public Product getProductBySku(String sku) {
        String sql = "SELECT * FROM RestauranteFiap.product WHERE sku = :sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", sku);
        RowMapper<Product> productRowMapper = new RowMapper<Product>() {
            @Override
            public Product mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {
                return new Product(
                        rs.getString("sku"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getFloat("monetaryValue"),
                        rs.getString("category")
                );
            }
        };
        return namedParameterJdbcTemplate.queryForObject(sql, params, productRowMapper);
    }

    @Transactional
    @Override
    public void createProduct(Product product) {
        String sql = "INSERT INTO RestauranteFiap.product (sku, name, description, monetaryValue, category) VALUES (:sku, :name, :description, :monetaryValue, :category)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", product.getSku());
        params.addValue("name", product.getName());
        params.addValue("description", product.getDescription());
        params.addValue("monetaryValue", product.getMonetaryValue());
        params.addValue("category", product.getCategory());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Transactional
    @Override
    public void updateProduct(String sku, Product product) {
        String sql = "UPDATE RestauranteFiap.product SET name=:name, description=:description, monetaryValue=:monetaryValue, category=:category WHERE sku=:sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", product.getSku());
        params.addValue("name", product.getName());
        params.addValue("description", product.getDescription());
        params.addValue("monetaryValue", product.getMonetaryValue());
        params.addValue("category", product.getCategory());
        namedParameterJdbcTemplate.update(sql, params);

    }

    @Transactional
    @Override
    public void deleteProduct(String sku) {
        String sql = "DELETE FROM RestauranteFiap.product WHERE sku=:sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", sku);
        namedParameterJdbcTemplate.update(sql, params);
    }
}
