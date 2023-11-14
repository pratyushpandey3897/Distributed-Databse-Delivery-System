package com.paseo.delivery.controller;

import com.paseo.delivery.model.Order;
import com.paseo.delivery.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller

public class DemoController {


    OrderService orderService;
    @GetMapping("/hello")
    public String sayHello() {
        return "hello"; // This is the name of a view (e.g., a Thymeleaf or JSP template).
    }

    @PostMapping("/order")
    public Order placeOrder(@RequestBody Order order) {
        OrderService orderService = null;
        return orderService.createOrder(order);
    }


}
