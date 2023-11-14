package com.paseo.delivery.repository;

import com.paseo.delivery.model.OrderItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepository {
    private NamedParameterJdbcTemplate template;

    public OrderItemRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        String query = "SELECT * FROM order_items WHERE orderId = ?";
        return template.query(query, new BeanPropertyRowMapper<>(OrderItem.class));
    }

    public void createOrderItem(OrderItem orderItem) {
        String query = "INSERT INTO order_items(orderId, productId, quantity, zipCode) VALUES(:orderId, :productId, :quantity, :zipCode)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderId", orderItem.getOrderId());
        params.addValue("productId", orderItem.getProductId());
        params.addValue("quantity", orderItem.getQuantity());
        params.addValue("zipCode", orderItem.getZipCode());
        template.update(query, params);
    }

    public void deleteOrderItem(Long orderId, Long productId) {
        String query = "DELETE FROM order_items WHERE orderId=:orderId AND productId=:productId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderId", orderId);
        params.addValue("productId", productId);
        template.update(query, params);
    }

    public void updateOrderItem(OrderItem orderItem) {
        String query = "UPDATE order_items SET quantity=:quantity, zipCode=:zipCode WHERE orderId=:orderId AND productId=:productId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("orderId", orderItem.getOrderId());
        params.addValue("productId", orderItem.getProductId());
        params.addValue("quantity", orderItem.getQuantity());
        params.addValue("zipCode", orderItem.getZipCode());
        template.update(query, params);
    }
}
