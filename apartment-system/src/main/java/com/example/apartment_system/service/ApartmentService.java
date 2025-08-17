package com.example.apartmentsystem.service;

import com.example.apartmentsystem.dto.ApartmentDTO;
import java.util.List;

public interface ApartmentService {
    ApartmentDTO createApartment(ApartmentDTO apartmentDTO);
    ApartmentDTO updateApartment(Long id, ApartmentDTO apartmentDTO);
    void deleteApartment(Long id);
    ApartmentDTO getApartmentById(Long id);
    List<ApartmentDTO> getAllApartments();
}
