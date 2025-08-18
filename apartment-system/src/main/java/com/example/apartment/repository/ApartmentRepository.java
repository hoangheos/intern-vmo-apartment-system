package com.example.apartment.repository;

import com.example.apartment.domain.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Optional<Apartment> findByNumber(String number);
}
