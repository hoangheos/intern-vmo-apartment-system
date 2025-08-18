package com.example.apartment.controller;

import com.example.apartment.domain.Apartment;
import com.example.apartment.dto.ApartmentDtos.CreateOrUpdate;
import com.example.apartment.service.ApartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@CrossOrigin
public class ApartmentController {
    private final ApartmentService service;
    public ApartmentController(ApartmentService service){ this.service = service; }

    @GetMapping public List<Apartment> all(){ return service.all(); }
    @GetMapping("/{id}") public Apartment get(@PathVariable Long id){ return service.get(id); }

    @PostMapping public ResponseEntity<Apartment> create(@Valid @RequestBody CreateOrUpdate dto){
        Apartment a = new Apartment();
        a.setNumber(dto.number());
        a.setArea(dto.area());
        a.setRooms(dto.rooms());
        a.setPhone(dto.phone());
        a.setEmail(dto.email());
        return ResponseEntity.ok(service.create(a));
    }

    @PutMapping("/{id}") public ResponseEntity<Apartment> update(@PathVariable Long id, @Valid @RequestBody CreateOrUpdate dto){
        Apartment a = new Apartment();
        a.setNumber(dto.number());
        a.setArea(dto.area());
        a.setRooms(dto.rooms());
        a.setPhone(dto.phone());
        a.setEmail(dto.email());
        return ResponseEntity.ok(service.update(id, a));
    }

    @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
