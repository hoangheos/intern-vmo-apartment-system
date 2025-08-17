package com.example.apartmentsystem.service;

import com.example.apartmentsystem.dto.ResidentDTO;
import java.util.List;

public interface ResidentService {
    ResidentDTO addResident(ResidentDTO residentDTO);
    ResidentDTO updateResident(Long id, ResidentDTO residentDTO);
    void removeResident(Long id);
    ResidentDTO getResidentById(Long id);
    List<ResidentDTO> getAllResidents();
}
