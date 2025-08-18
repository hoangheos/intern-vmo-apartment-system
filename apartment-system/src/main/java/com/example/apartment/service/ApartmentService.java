package com.example.apartment.service;

import com.example.apartment.domain.Apartment;
import com.example.apartment.exception.ApiException;
import com.example.apartment.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {
    private final ApartmentRepository repo;

    public ApartmentService(ApartmentRepository repo) { this.repo = repo; }

    public Apartment create(Apartment a) {
        repo.findByNumber(a.getNumber()).ifPresent(x -> { throw new ApiException("Apartment number exists"); });
        return repo.save(a);
    }
    public Apartment update(Long id, Apartment data) {
        Apartment a = repo.findById(id).orElseThrow(() -> new ApiException("Apartment not found"));
        a.setNumber(data.getNumber());
        a.setArea(data.getArea());
        a.setRooms(data.getRooms());
        a.setPhone(data.getPhone());
        a.setEmail(data.getEmail());
        return repo.save(a);
    }
    public void delete(Long id){ repo.deleteById(id); }
    public Apartment get(Long id){ return repo.findById(id).orElseThrow(() -> new ApiException("Not found")); }
    public List<Apartment> all(){ return repo.findAll(); }
}
