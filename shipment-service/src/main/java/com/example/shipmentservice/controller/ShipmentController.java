package com.example.shipmentservice.controller;

import com.example.shipmentservice.model.Shipment;
import com.example.shipmentservice.service.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentController {

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @GetMapping("/{trackingnumber}")
    public Shipment findShipmentByTrackingNumber(@PathVariable Long trackingNumber) {
        return shipmentService.getShipmentByTrackingNumber(trackingNumber);
    }

    @PostMapping("/addshipment")
    public Shipment addShipment(@RequestBody Shipment shipment) {
        return shipmentService.addShipment(shipment);
    }
}