package com.paseo.delivery.model;

public class DeliveryAgent {
    private String agentId;
    private String agentName;
    private String orderId;
    private String zipCode;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentName () {
        return agentName;
    }

    public void setAgentName (String agentName) {
        this.agentName = agentName;
    }

    public String getOrderId () {
        return orderId;
    }

    public void setOrderId (String orderId) {
        this.orderId = orderId;
    }

    public String getZipCode () {
        return zipCode;
    }

    public void setZipCode (String zipCode) {
        this.zipCode = zipCode;
    }
}
