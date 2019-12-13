package com.example.shipmentservice.service;

import com.example.shipmentservice.model.Shipment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ShipmentService {

    public Shipment getShipmentByTrackingNumber(@PathVariable Long trackingNumber);

    public Shipment addShipment(@RequestBody Shipment shipment);
}
