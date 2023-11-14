package com.paseo.delivery.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private String customerId;
    private LocalDate orderDate;
    private Long zipCode;
    private String agentId;

    public String getAgentId () {
        return agentId;
    }

    public void setAgentId (String agentId) {
        this.agentId = agentId;
    }

    public void setZipCode (Long zipCode) {
        this.zipCode = zipCode;
    }

    public Long getZipCode () {
        return zipCode;
    }
    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate () {
        return orderDate;
    }

    public void setOrderDate (LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId () {
        return customerId;
    }

    public void setCustomerId (String customerId) {
        this.customerId = customerId;
    }
}
