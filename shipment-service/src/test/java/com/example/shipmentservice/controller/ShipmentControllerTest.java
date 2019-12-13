package com.example.shipmentservice.controller;

import com.example.shipmentservice.model.Shipment;
import com.example.shipmentservice.service.ShipmentService;
import com.example.shipmentservice.service.ShipmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@RunWith(MockitoJUnitRunner.class)
public class ShipmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @InjectMocks
    private Shipment shipment;

    @InjectMocks
    private ShipmentController shipmentController;

    @MockBean
    private ShipmentService shipmentService;

    @Before
    public void init() {
        shipment = new Shipment();

        shipment.setId(1L);
        shipment.setName("test name");
        shipment.setTrackingNumber(1L);

//        mockMvc = MockMvcBuilders.standaloneSetup(shipmentController).build();
    }

    @Test
    public void getShipment_Shipment_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/{trackingnumber}", 1L);

        when(shipmentService.getShipmentByTrackingNumber(anyLong())).thenReturn(shipment);

        MvcResult result = mockMvc
                .perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"id\":1,\"title\":\"Test Post Title\",\"description\":\"Test Post Description\",\"user_id\":1,\"user\":{\"username\":\"testUser\"}}\n"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void addShipment_Shipment_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/addshipment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"shipment_id\":\"1\",\"name\":\"test name\",\"tracking_number\":\"1\"}");

        when(shipmentService.addShipment(any())).thenReturn(shipment);

        MvcResult result = mockMvc
                .perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"id\":1,\"title\":\"Test Post Title\",\"description\":\"Test Post Description\",\"user_id\":1,\"user\":{\"username\":\"testUser\"}}\n"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

}
