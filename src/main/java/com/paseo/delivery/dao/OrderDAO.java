package com.paseo.delivery.dao;

import com.paseo.delivery.model.Order;
import com.paseo.delivery.rowmapper.OrderRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO {


    private JdbcTemplate jdbcTemplate;

    public OrderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Order getOrder(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrderRowMapper ());
    }

    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    public void createOrder(Order order) {
        String sql = "INSERT INTO orders (customer_name, order_date) VALUES (?, ?)";
        jdbcTemplate.update(sql, order.getCustomerId (), order.getOrderDate());
    }

    public void updateOrder(Order order) {
        String sql = "UPDATE orders SET customer_name = ?, order_date = ? WHERE id = ?";
        jdbcTemplate.update(sql, order.getCustomerId (), order.getOrderDate(), order.getId());
    }

    public void deleteOrder(Long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
