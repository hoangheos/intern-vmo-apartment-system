package com.example.apartment.controller;

import com.example.apartment.domain.Apartment;
import com.example.apartment.domain.Resident;
import com.example.apartment.service.ApartmentService;
import com.example.apartment.service.ResidentService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/search")
@CrossOrigin
public class SearchController {
    private final ResidentService residentService;
    private final ApartmentService apartmentService;

    public SearchController(ResidentService residentService, ApartmentService apartmentService) {
        this.residentService = residentService;
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public Map<String, Object> search(@RequestParam(required = false) String residentName,
                                      @RequestParam(required = false) String apartmentNumber) {
        Map<String,Object> res = new HashMap<>();
        if (residentName != null) res.put("residents", residentService.searchByName(residentName));
        if (apartmentNumber != null) {
            List<Resident> residents = residentService.byApartmentNumber(apartmentNumber);
            res.put("residentsByApartment", residents);
        }
        return res;
    }
}
