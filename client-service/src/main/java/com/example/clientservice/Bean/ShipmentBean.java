package com.example.clientservice.Bean;

public class ShipmentBean {
    private Long shipmentId;
    private String name;
    private Long trackingNumber;

    public ShipmentBean() { }

    public ShipmentBean(Long shipmentId, String name, Long trackingNumber) {
        this.shipmentId = shipmentId;
        this.name = name;
        this.trackingNumber = trackingNumber;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Long trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
