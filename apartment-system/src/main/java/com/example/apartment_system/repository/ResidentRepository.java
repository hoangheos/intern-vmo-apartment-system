package com.example.apartmentsystem.repository;

import com.example.apartmentsystem.model.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    Optional<Resident> findByEmail(String email);

    List<Resident> findByPhoneNumber(String phoneNumber);

    List<Resident> findByApartmentId(Long apartmentId);
}
