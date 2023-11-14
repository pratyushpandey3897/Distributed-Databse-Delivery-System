package com.paseo.delivery.model;

public class OrderItem {
    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    private Long orderId;

    public Long getProductId () {
        return productId;
    }

    public void setProductId (Long productId) {
        this.productId = productId;
    }

    private Long productId;

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public Long getZipCode () {
        return zipCode;
    }

    public void setZipCode (Long zipCode) {
        this.zipCode = zipCode;
    }

    private Long zipCode;


}
