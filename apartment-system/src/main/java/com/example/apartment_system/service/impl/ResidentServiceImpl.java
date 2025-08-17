package com.example.apartmentsystem.service.impl;

import com.example.apartmentsystem.dto.ResidentDTO;
import com.example.apartmentsystem.model.Resident;
import com.example.apartmentsystem.repository.ResidentRepository;
import com.example.apartmentsystem.service.ResidentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public ResidentDTO addResident(ResidentDTO residentDTO) {
        Resident resident = new Resident();
        resident.setName(residentDTO.getName());
        resident.setPhoneNumber(residentDTO.getPhoneNumber());
        resident.setApartmentId(residentDTO.getApartmentId());
        return mapToDTO(residentRepository.save(resident));
    }

    @Override
    public ResidentDTO updateResident(Long id, ResidentDTO residentDTO) {
        Resident resident = residentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
        resident.setName(residentDTO.getName());
        resident.setPhoneNumber(residentDTO.getPhoneNumber());
        resident.setApartmentId(residentDTO.getApartmentId());
        return mapToDTO(residentRepository.save(resident));
    }

    @Override
    public void removeResident(Long id) {
        residentRepository.deleteById(id);
    }

    @Override
    public ResidentDTO getResidentById(Long id) {
        return residentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Resident not found"));
    }

    @Override
    public List<ResidentDTO> getAllResidents() {
        return residentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ResidentDTO mapToDTO(Resident resident) {
        return new ResidentDTO(resident.getId(), resident.getName(), resident.getPhoneNumber(), resident.getApartmentId());
    }
}
