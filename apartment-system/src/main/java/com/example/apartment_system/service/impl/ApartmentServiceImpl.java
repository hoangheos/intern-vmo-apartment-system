package com.example.apartmentsystem.service.impl;

import com.example.apartmentsystem.dto.ApartmentDTO;
import com.example.apartmentsystem.model.Apartment;
import com.example.apartmentsystem.repository.ApartmentRepository;
import com.example.apartmentsystem.service.ApartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public ApartmentDTO createApartment(ApartmentDTO apartmentDTO) {
        Apartment apartment = new Apartment();
        apartment.setName(apartmentDTO.getName());
        apartment.setNumberOfRooms(apartmentDTO.getNumberOfRooms());
        apartment.setArea(apartmentDTO.getArea());
        return mapToDTO(apartmentRepository.save(apartment));
    }

    @Override
    public ApartmentDTO updateApartment(Long id, ApartmentDTO apartmentDTO) {
        Apartment apartment = apartmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apartment not found"));
        apartment.setName(apartmentDTO.getName());
        apartment.setNumberOfRooms(apartmentDTO.getNumberOfRooms());
        apartment.setArea(apartmentDTO.getArea());
        return mapToDTO(apartmentRepository.save(apartment));
    }

    @Override
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);
    }

    @Override
    public ApartmentDTO getApartmentById(Long id) {
        return apartmentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Apartment not found"));
    }

    @Override
    public List<ApartmentDTO> getAllApartments() {
        return apartmentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ApartmentDTO mapToDTO(Apartment apartment) {
        return new ApartmentDTO(apartment.getId(), apartment.getName(), apartment.getNumberOfRooms(), apartment.getArea());
    }
}
