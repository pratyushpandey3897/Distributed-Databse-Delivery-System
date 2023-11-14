package com.paseo.delivery.model;

public class Inventory {
    private String uniqueId;
    private String warehouseId;
    private String orderId;
    private String medicineId;
    private String zipCode;

    public String getWarehouseId () {
        return warehouseId;
    }

    public void setWarehouseId (String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getOrderId () {
        return orderId;
    }

    public void setOrderId (String orderId) {
        this.orderId = orderId;
    }

    public String getMedicineId () {
        return medicineId;
    }

    public void setMedicineId (String medicineId) {
        this.medicineId = medicineId;
    }

    public String getZipCode () {
        return zipCode;
    }

    public void setZipCode (String zipCode) {
        this.zipCode = zipCode;
    }


    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
