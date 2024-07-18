package br.com.fiap.techchallange.infrastructure.bd;

import br.com.fiap.techchallange.adapters.gateways.repository.IOrderRepository;
import br.com.fiap.techchallange.core.entity.Order;
import br.com.fiap.techchallange.core.entity.Payment;
import br.com.fiap.techchallange.core.entity.Product;
import br.com.fiap.techchallange.core.entity.vo.Item;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class MySQLOrderRepository implements IOrderRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public MySQLOrderRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Transactional
    @Override
    public void create(Order order) {
        String sql = "INSERT INTO dbtechchallange.order (id, number_order, status) values (:id, :number_order, :status)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", order.getId());
        params.addValue("number_order", order.getNumberOrder());
        params.addValue("status", order.getStatus());
        namedParameterJdbcTemplate.update(sql, params);

        createPayment(order.getId(), order.getPayment());
    }

    @Override
    public void update(Order order) {
        StringBuilder sql = new StringBuilder("UPDATE dbtechchallange.order SET ");
        Map<String, Object> params = new HashMap<>();

        sql.append("number_order = :numberOrder, ");
        params.put("numberOrder", order.getNumberOrder());

        sql.append("status = :status, ");
        params.put("status", order.getStatus());

        sql.delete(sql.length() - 2, sql.length());

        sql.append(" WHERE id = :id");
        params.put("id", order.getId());

        namedParameterJdbcTemplate.update(sql.toString(), params);
    }

    private void createPayment(String orderId, Payment payment){
        String sql = "INSERT INTO dbtechchallange.payment (id, order_id, value, method, date_payment, gateway_payment, status, reading_code, processing_code) " +
                     "values (:id, :order_id, :value, :method, :date_payment, :gateway_payment, :status, :reading_code, :processing_code)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("order_id",orderId);
        params.addValue("id", payment.getId());
        params.addValue("value", payment.getMonetaryValue());
        params.addValue("method", payment.getMethod());
        params.addValue("date_payment", payment.getPaymentDate());
        params.addValue("gateway_payment", payment.getGatewayPayment());
        params.addValue("status", payment.getStatus());
        params.addValue("reading_code", payment.getReadingCode());
        params.addValue("processing_code", payment.getProcessingCode());

        namedParameterJdbcTemplate.update(sql, params);
    }

    @Transactional
    @Override
    public void addProduct(Order order, String sku, Integer qtd){

        String sql = "INSERT INTO dbtechchallange.item (order_id, sku, quantity) values (:order_id, :sku, :quantity)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("order_id", order.getId());
        params.addValue("sku", sku);
        params.addValue("quantity", qtd);

        namedParameterJdbcTemplate.update(sql, params);

        this.update(order);
    }

    @Transactional
    @Override
    public void updatePayment(Order order) {

        StringBuilder sql = new StringBuilder("UPDATE dbtechchallange.payment SET ");
        Map<String, Object> params = new HashMap<>();

        Payment payment = order.getPayment();

        sql.append("value = :value, ");
        params.put("value", payment.getMonetaryValue());

        sql.append("method = :method, ");
        params.put("method", payment.getMethod());

        sql.append("date_payment = :date_payment, ");
        params.put("date_payment", payment.getPaymentDate());

        sql.append("gateway_payment = :gateway_payment, ");
        params.put("gateway_payment", payment.getGatewayPayment());

        sql.append("status = :status, ");
        params.put("status", payment.getStatus());

        sql.append("reading_code = :reading_code, ");
        params.put("reading_code", payment.getReadingCode());

        sql.append("processing_code = :processing_code, ");
        params.put("processing_code", payment.getProcessingCode());

        sql.delete(sql.length() - 2, sql.length());

        sql.append(" WHERE order_id = :order_id");
        params.put("order_id", order.getId());

        namedParameterJdbcTemplate.update(sql.toString(), params);

        this.update(order);
    }

    @Transactional
    @Override
    public void removeProduct(Order order, String sku) {
        String sql = "DELETE FROM dbtechchallange.item WHERE order_id = :order_id and sku = :sku";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("order_id", order.getId());
        params.addValue("sku", sku);

        namedParameterJdbcTemplate.update(sql, params);

        this.update(order);
    }

    @Override
    public Order getByOrderNumber(int order_number) {
        String sql = "SELECT * FROM dbtechchallange.order WHERE number_order = :order_number";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("order_number", order_number);

        return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Order>() {
            @Override
            public Order mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {

                return new Order(rs.getString("id"),
                        rs.getInt("number_order"),
                        rs.getString("status"));
            }
        });
    }



    @Transactional
    @Override
    public Order get(String ordemId) {
        String sql = "SELECT * FROM dbtechchallange.order WHERE id = :ordemId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ordemId", ordemId);

        Map<String, Item> items = this.getItems(ordemId);
        Payment payment = this.getPayment(ordemId);

        return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Order>() {
            @Override
            public Order mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {

                return new Order(rs.getString("id"),
                        rs.getInt("number_order"),
                        (HashMap<String, Item>) items,
                        payment,
                        rs.getString("status"));
            }
        });
    }

    private Payment getPayment(String ordemId){
        String sql = "SELECT * FROM dbtechchallange.payment WHERE order_id = :ordemId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ordemId", ordemId);

        Payment payment = namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<Payment>() {
            @Override
            public Payment mapRow(@NotNull ResultSet rs, int rowNum) throws SQLException {

                return new Payment(rs.getString("id"),
                                              rs.getString("order_id"),
                                              rs.getFloat("value"),
                                              rs.getString("gateway_payment"),
                                              rs.getString("date_payment"),
                                              rs.getString("method"),
                                              rs.getString("status"),
                                              rs.getString("reading_code"),
                                              rs.getString("processing_code"));
            }
        });

        return Objects.requireNonNullElseGet(payment, () -> new Payment(ordemId));
    }

    private Map<String, Item> getItems(String ordemId){
        String sql = "SELECT * FROM dbtechchallange.item WHERE order_id = :ordemId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("ordemId", ordemId);
        Map<String, Item> items = new HashMap<String, Item>();

        namedParameterJdbcTemplate.query(sql, params, new RowCallbackHandler() {
            public void processRow(@NotNull ResultSet rs) throws SQLException {
                Item item = new Item(getProduct(rs.getString("sku")), rs.getInt("quantity"));
                items.put(rs.getString("sku"), item);
            }
        });
        return items;
    }

    private Product getProduct(String sku){
        String sql = "SELECT * FROM dbtechchallange.product WHERE sku = :sku";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("sku", sku);
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
