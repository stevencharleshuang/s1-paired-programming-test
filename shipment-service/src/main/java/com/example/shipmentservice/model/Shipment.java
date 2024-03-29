package com.example.shipmentservice.model;

import javax.persistence.*;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @Column(name = "shipment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "tracking_number")
    private Long trackingNumber;

    public Shipment () { }

    public Shipment(String name, Long trackingNumber) {
        this.name = name;
        this.trackingNumber = trackingNumber;
    }

    public Long getId() {
        return shipmentId;
    }

    public void setId(Long id) {
        this.shipmentId = id;
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
