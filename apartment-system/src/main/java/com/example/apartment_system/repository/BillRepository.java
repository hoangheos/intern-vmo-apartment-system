package com.example.apartmentsystem.repository;

import com.example.apartmentsystem.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByApartmentId(Long apartmentId);

    List<Bill> findByResidentId(Long residentId);

    List<Bill> findByDueDateBeforeAndStatus(LocalDate dueDate, String status);
}
