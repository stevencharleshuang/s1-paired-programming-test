package com.example.clientservice.Feign;

import com.example.clientservice.Bean.ShipmentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("shipment")
public interface ShipmentClient {

    @GetMapping("shipment/{trackingnumber}")
    public ShipmentBean getShipmentByTrackingNumber(@PathVariable Long trackingNumber);

    @PostMapping("shipment/addshipment")
    public ShipmentBean addShipment(@RequestBody ShipmentBean shipment);
}
