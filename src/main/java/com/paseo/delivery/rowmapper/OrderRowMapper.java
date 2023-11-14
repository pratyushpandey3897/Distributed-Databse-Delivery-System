package com.paseo.delivery.rowmapper;

import com.paseo.delivery.model.Order;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(rs.getLong("id"));
        order.setCustomerId (rs.getString("customer_name"));
        order.setOrderDate(rs.getDate("order_date").toLocalDate());
        order.setZipCode (rs.getLong ("zipcode"));
        return order;
    }
}
