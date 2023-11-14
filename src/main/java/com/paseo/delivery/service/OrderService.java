package com.paseo.delivery.service;

import com.paseo.delivery.dao.OrderDAO;
import com.paseo.delivery.model.Order;

import java.util.List;

public class OrderService {

    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order getOrder(Long id) {
        return orderDAO.getOrder(id);
    }

    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public Order createOrder(Order order) {
        //
        orderDAO.createOrder(order);

        // invetory check
        // lock
        // delivery

        return order;
    }

    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(Long id) {
        orderDAO.deleteOrder(id);
    }
}
