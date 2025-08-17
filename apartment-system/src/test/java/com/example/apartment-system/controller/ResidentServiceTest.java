package com.example.apartmentsystem.service;

import com.example.apartmentsystem.dto.request.ResidentRequest;
import com.example.apartmentsystem.dto.response.ResidentResponse;
import com.example.apartmentsystem.model.Resident;
import com.example.apartmentsystem.repository.ResidentRepository;
import com.example.apartmentsystem.service.impl.ResidentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ResidentServiceTest {

    @Mock
    private ResidentRepository residentRepository;

    @InjectMocks
    private ResidentServiceImpl residentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateResident() {
        ResidentRequest request = new ResidentRequest();
        request.setName("Nguyen Van A");
        request.setPhone("0123456789");

        Resident resident = new Resident();
        resident.setId(1L);
        resident.setName("Nguyen Van A");
        resident.setPhone("0123456789");

        when(residentRepository.save(any(Resident.class))).thenReturn(resident);

        ResidentResponse response = residentService.createResident(request);

        assertNotNull(response);
        assertEquals("Nguyen Van A", response.getName());
        verify(residentRepository, times(1)).save(any(Resident.class));
    }

    @Test
    void testGetResidentById() {
        Resident resident = new Resident();
        resident.setId(1L);
        resident.setName("Nguyen Van A");

        when(residentRepository.findById(1L)).thenReturn(Optional.of(resident));

        ResidentResponse response = residentService.getResidentById(1L);

        assertNotNull(response);
        assertEquals("Nguyen Van A", response.getName());
    }
}
