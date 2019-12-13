package com.example.shipmentservice.controller;

import com.example.shipmentservice.model.Shipment;
import com.example.shipmentservice.service.ShipmentService;
import com.example.shipmentservice.service.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/{trackingnumber}")
    public Shipment findShipmentByTrackingNumber(@PathVariable Long trackingnumber) {
        return shipmentService.getShipmentByTrackingNumber(trackingnumber);
    }

    @PostMapping("/addshipment")
    public Shipment addShipment(@RequestBody Shipment shipment) {
        return shipmentService.addShipment(shipment);
    }
}
