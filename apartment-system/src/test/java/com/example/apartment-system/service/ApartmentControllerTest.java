package com.example.apartmentsystem.controller;

import com.example.apartmentsystem.dto.request.ApartmentRequest;
import com.example.apartmentsystem.dto.response.ApartmentResponse;
import com.example.apartmentsystem.service.ApartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ApartmentController.class)
class ApartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApartmentService apartmentService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateApartment() throws Exception {
        ApartmentRequest request = new ApartmentRequest();
        request.setName("A101");
        request.setFloor(1);

        ApartmentResponse response = new ApartmentResponse();
        response.setId(1L);
        response.setName("A101");
        response.setFloor(1);

        Mockito.when(apartmentService.createApartment(any(ApartmentRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/apartments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("A101"))
                .andExpect(jsonPath("$.floor").value(1));
    }

    @Test
    void testGetApartmentById() throws Exception {
        ApartmentResponse response = new ApartmentResponse();
        response.setId(1L);
        response.setName("A101");
        response.setFloor(1);

        Mockito.when(apartmentService.getApartmentById(1L)).thenReturn(response);

        mockMvc.perform(get("/api/apartments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("A101"))
                .andExpect(jsonPath("$.floor").value(1));
    }
}
