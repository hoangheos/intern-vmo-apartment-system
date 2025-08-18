package com.example.apartment.controller;

import com.example.apartment.domain.Resident;
import com.example.apartment.dto.ResidentDtos.CreateOrUpdate;
import com.example.apartment.service.ResidentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/residents")
@CrossOrigin
public class ResidentController {
    private final ResidentService service;
    public ResidentController(ResidentService service){ this.service = service; }

    @GetMapping public List<Resident> all(){ return service.all(); }

    @PostMapping public ResponseEntity<Resident> create(@Valid @RequestBody CreateOrUpdate dto){
        Resident r = toEntity(dto);
        return ResponseEntity.ok(service.create(r, dto.apartmentId()));
    }

    @PutMapping("/{id}") public ResponseEntity<Resident> update(@PathVariable Long id, @Valid @RequestBody CreateOrUpdate dto){
        Resident r = toEntity(dto);
        return ResponseEntity.ok(service.update(id, r, dto.apartmentId()));
    }

    @DeleteMapping("/{id}") public ResponseEntity<?> softRemove(@PathVariable Long id){
        service.softRemove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Resident> searchByName(@RequestParam("q") String q){ return service.searchByName(q); }

    @GetMapping("/by-apartment/{number}")
    public List<Resident> byApartment(@PathVariable String number){ return service.byApartmentNumber(number); }

    private Resident toEntity(CreateOrUpdate dto){
        Resident r = new Resident();
        r.setName(dto.name());
        r.setEmail(dto.email());
        r.setPhone(dto.phone());
        r.setIdCard(dto.idCard());
        r.setBirthYear(dto.birthYear());
        r.setGender(dto.gender());
        r.setActive(dto.active());
        r.setMoveInDate(dto.moveInDate());
        r.setMoveOutDate(dto.moveOutDate());
        return r;
    }
}
