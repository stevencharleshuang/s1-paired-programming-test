package com.example.shipmentservice.repository;

import com.example.shipmentservice.model.Shipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    public Shipment findByTrackingNumber(Long trackingNumber);

}
