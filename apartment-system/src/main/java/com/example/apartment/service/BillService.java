package com.example.apartment.service;

import com.example.apartment.domain.Apartment;
import com.example.apartment.domain.Bill;
import com.example.apartment.exception.ApiException;
import com.example.apartment.repository.ApartmentRepository;
import com.example.apartment.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillService {
    private final BillRepository repo;
    private final ApartmentRepository apartmentRepo;

    public BillService(BillRepository repo, ApartmentRepository apartmentRepo) {
        this.repo = repo;
        this.apartmentRepo = apartmentRepo;
    }

    public Bill upsert(Bill b, Long apartmentId) {
        Apartment a = apartmentRepo.findById(apartmentId)
                .orElseThrow(() -> new ApiException("Apartment not found"));

        LocalDate month = b.getBillingMonth();

        // Nếu đã có bill của tháng này cho apartment => cập nhật
        Bill target = repo.findByApartment_IdAndBillingMonth(a.getId(), month)
                .map(existing -> {
                    existing.setElectricityCost(b.getElectricityCost());
                    existing.setWaterCost(b.getWaterCost());
                    existing.setCommonFee(b.getCommonFee());
                    existing.setElevatorMaintenanceFee(b.getElevatorMaintenanceFee());
                    existing.setParkingFee(b.getParkingFee());
                    existing.setBillingMonth(b.getBillingMonth());
                    return existing;
                })
                .orElse(b); // Nếu chưa có thì tạo mới

        target.setApartment(a);

        // Tính tổng
        double total = (target.getElectricityCost() == null ? 0 : target.getElectricityCost())
                + (target.getWaterCost() == null ? 0 : target.getWaterCost())
                + (target.getCommonFee() == null ? 0 : target.getCommonFee())
                + (target.getElevatorMaintenanceFee() == null ? 0 : target.getElevatorMaintenanceFee())
                + (target.getParkingFee() == null ? 0 : target.getParkingFee());

        target.setTotalAmount(total);

        return repo.save(target);
    }

    public List<Bill> byApartmentNumber(String no) {
        return repo.findByApartment_Number(no);
    }

    public List<Bill> all() {
        return repo.findAll();
    }
}
