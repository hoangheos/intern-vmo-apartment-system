package com.example.apartmentsystem.repository;

import com.example.apartmentsystem.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    Optional<Apartment> findByApartmentNumber(String apartmentNumber);

    boolean existsByApartmentNumber(String apartmentNumber);
}
