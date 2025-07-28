package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/flats")
public class FlatController {

    @Autowired
    private FlatRepository flatRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public Iterable<Flat> getAllFlats() {
        return flatRepository.findAll();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Optional<Flat> getFlatById(@PathVariable Long id) {
        return flatRepository.findById(id);
    }

    @PostMapping("/save")
    public void create(@RequestBody Flat flat) {
        flatRepository.save(flat);
        System.err.println(flat);
    }

}
