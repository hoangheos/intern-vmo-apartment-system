package com.example.apartment.service;

import com.example.apartment.domain.Apartment;
import com.example.apartment.domain.Resident;
import com.example.apartment.exception.ApiException;
import com.example.apartment.repository.ApartmentRepository;
import com.example.apartment.repository.ResidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {
    private final ResidentRepository repo;
    private final ApartmentRepository apartmentRepo;

    public ResidentService(ResidentRepository repo, ApartmentRepository apartmentRepo) {
        this.repo = repo; this.apartmentRepo = apartmentRepo;
    }

    public Resident create(Resident r, Long apartmentId) {
        Apartment a = apartmentRepo.findById(apartmentId).orElseThrow(() -> new ApiException("Apartment not found"));
        r.setApartment(a);
        return repo.save(r);
    }

    public Resident update(Long id, Resident data, Long apartmentId) {
        Resident r = repo.findById(id).orElseThrow(() -> new ApiException("Resident not found"));
        if (apartmentId != null) {
            Apartment a = apartmentRepo.findById(apartmentId).orElseThrow(() -> new ApiException("Apartment not found"));
            r.setApartment(a);
        }
        r.setName(data.getName());
        r.setEmail(data.getEmail());
        r.setPhone(data.getPhone());
        r.setIdCard(data.getIdCard());
        r.setBirthYear(data.getBirthYear());
        r.setGender(data.getGender());
        r.setActive(data.isActive());
        r.setMoveInDate(data.getMoveInDate());
        r.setMoveOutDate(data.getMoveOutDate());
        return repo.save(r);
    }

    public void softRemove(Long id) {
        Resident r = repo.findById(id).orElseThrow(() -> new ApiException("Resident not found"));
        r.setActive(false);
        repo.save(r);
    }

    public List<Resident> all(){ return repo.findAll(); }
    public List<Resident> searchByName(String q){ return repo.findByNameContainingIgnoreCase(q); }
    public List<Resident> byApartmentNumber(String no){ return repo.findByApartment_Number(no); }
}
