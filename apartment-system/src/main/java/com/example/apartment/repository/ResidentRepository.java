package com.example.apartment.repository;

import com.example.apartment.domain.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    List<Resident> findByNameContainingIgnoreCase(String name);
    List<Resident> findByApartment_Number(String number);
}
