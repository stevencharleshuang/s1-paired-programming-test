package com.example.shipmentservice.service;

import com.example.shipmentservice.model.Shipment;
import com.example.shipmentservice.repository.ShipmentRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@EnableWebMvc
@RunWith(MockitoJUnitRunner.class)
public class ShipmentServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ShipmentServiceImpl shipmentService;

    @InjectMocks
    private Shipment shipment;

    @Mock
    private ShipmentRepository shipmentRepository;

    @Before
    public void init() {
        shipment = new Shipment();

        shipment.setId(1L);
        shipment.setName("test name");
        shipment.setTrackingNumber(1L);
    }

    @Test
    public void getShipmentByTrackingNumber_Shipment_Success() {
        when(shipmentRepository.findByTrackingNumber(anyLong())).thenReturn(shipment);

        Shipment foundShipment = shipmentService.getShipmentByTrackingNumber(1L);

        assertNotNull(foundShipment);
        assertEquals(shipment.getTrackingNumber(), foundShipment.getTrackingNumber());
    }

    @Test
    public void addShipment_Shipment_Success() {
        when(shipmentRepository.save(any())).thenReturn(shipment);

        Shipment savedShipment = shipmentService.addShipment(shipment);

        assertNotNull(savedShipment);
        assertEquals(shipment.getTrackingNumber(), savedShipment.getTrackingNumber());
    }
}
