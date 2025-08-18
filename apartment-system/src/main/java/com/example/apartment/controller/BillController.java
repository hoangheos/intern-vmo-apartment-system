package com.example.apartment.controller;

import com.example.apartment.domain.Bill;
import com.example.apartment.dto.BillDtos.CreateOrUpdate;
import com.example.apartment.service.BillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin
public class BillController {
    private final BillService service;
    public BillController(BillService service){ this.service = service; }

    @GetMapping public List<Bill> all(){ return service.all(); }

    @PostMapping public ResponseEntity<Bill> upsert(@Valid @RequestBody CreateOrUpdate dto){
        Bill b = toEntity(dto);
        return ResponseEntity.ok(service.upsert(b, dto.apartmentId()));
    }

    @GetMapping("/by-apartment/{number}")
    public List<Bill> byApartment(@PathVariable("number") String number){ return service.byApartmentNumber(number); }

    private Bill toEntity(CreateOrUpdate dto){
        Bill b = new Bill();
        b.setBillingMonth(dto.billingMonth());
        b.setElectricityKwh(dto.electricityKwh());
        b.setWaterM3(dto.waterM3());
        b.setElectricityCost(dto.electricityCost());
        b.setWaterCost(dto.waterCost());
        b.setCommonFee(dto.commonFee());
        b.setElevatorMaintenanceFee(dto.elevatorMaintenanceFee());
        b.setParkingFee(dto.parkingFee());
        b.setDueDate(dto.dueDate());
        b.setPaid(dto.paid());
        return b;
    }
}
