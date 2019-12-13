package com.example.shipmentservice.repository;

import com.example.shipmentservice.model.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

    @Query(value="FROM Shipment s WHERE s.trackingNumber = :trackingNumber")
    public Shipment findByTrackingNumber(Long trackingNumber);

}
