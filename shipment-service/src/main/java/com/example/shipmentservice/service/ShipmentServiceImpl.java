package com.example.shipmentservice.service;

import com.example.shipmentservice.model.Shipment;
import com.example.shipmentservice.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public Shipment getShipmentByTrackingNumber(Long trackingNumber) {
        return shipmentRepository.findByTrackingNumber(trackingNumber);
    }

    @Override
    public Shipment addShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
