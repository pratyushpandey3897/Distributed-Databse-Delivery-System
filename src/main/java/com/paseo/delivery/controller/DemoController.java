package com.paseo.delivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello"; // This is the name of a view (e.g., a Thymeleaf or JSP template).
    }
}
