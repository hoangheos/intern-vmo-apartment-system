package com.example.apartment.repository;

import com.example.apartment.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> findByApartment_IdAndBillingMonth(Long apartmentId, LocalDate billingMonth);
    List<Bill> findByApartment_Number(String number);
}
