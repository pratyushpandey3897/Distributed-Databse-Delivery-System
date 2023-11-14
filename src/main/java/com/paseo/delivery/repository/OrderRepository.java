package com.paseo.delivery.repository;

import com.paseo.delivery.model.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private NamedParameterJdbcTemplate template;

    public OrderRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<Order> getAllOrders() {
        String query = "SELECT * FROM orders";
        return template.query(query, new BeanPropertyRowMapper<>(Order.class));
    }

    public Order getOrderById(String orderId) {
        String query = "SELECT * FROM orders WHERE orderId=:orderId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderId", orderId);
        return template.queryForObject(query, params, new BeanPropertyRowMapper<> (Order.class));
    }

    public void createOrder(Order order) {
        String query = "INSERT INTO orders(id, customerId, orderDate, zipCode, agentId) VALUES(:id, :customerId, :orderDate, :zipCode, :agentId)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", order.getId());
        params.addValue("customerId", order.getCustomerId());
        params.addValue("orderDate", order.getOrderDate());
        params.addValue("zipCode", order.getZipCode());
        params.addValue("agentId", order.getAgentId());
        template.update(query, params);
    }

    public void deleteOrder(Long id) {
        String query = "DELETE FROM orders WHERE id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        template.update(query, params);
    }

    public void updateOrder(Order order) {
        String query = "UPDATE orders SET customerId=:customerId, orderDate=:orderDate, zipCode=:zipCode, agentId=:agentId WHERE id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", order.getId());
        params.addValue("customerId", order.getCustomerId());
        params.addValue("orderDate", order.getOrderDate());
        params.addValue("zipCode", order.getZipCode());
        params.addValue("agentId", order.getAgentId());
        template.update(query, params);
    }
}
