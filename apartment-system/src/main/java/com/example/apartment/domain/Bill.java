package com.example.apartment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills", uniqueConstraints = @UniqueConstraint(columnNames = {"apartment_id","billingMonth"}))
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    // Store first day of the month (e.g., 2025-07-01)
    @Column(nullable = false)
    private LocalDate billingMonth;

    // Usage
    @PositiveOrZero private Double electricityKwh = 0.0;
    @PositiveOrZero private Double waterM3 = 0.0;

    // Costs
    @PositiveOrZero private Double electricityCost = 0.0;
    @PositiveOrZero private Double waterCost = 0.0;
    @PositiveOrZero private Double commonFee = 0.0; // vệ sinh chung
    @PositiveOrZero private Double elevatorMaintenanceFee = 0.0;
    @PositiveOrZero private Double parkingFee = 0.0;

    @PositiveOrZero private Double totalAmount = 0.0;

    private LocalDate dueDate;
    private boolean paid = false;
    private LocalDate paidAt;

    // getters & setters
    public Long getId() { return id; }
    public Apartment getApartment() { return apartment; }
    public void setApartment(Apartment apartment) { this.apartment = apartment; }
    public LocalDate getBillingMonth() { return billingMonth; }
    public void setBillingMonth(LocalDate billingMonth) { this.billingMonth = billingMonth; }
    public Double getElectricityKwh() { return electricityKwh; }
    public void setElectricityKwh(Double electricityKwh) { this.electricityKwh = electricityKwh; }
    public Double getWaterM3() { return waterM3; }
    public void setWaterM3(Double waterM3) { this.waterM3 = waterM3; }
    public Double getElectricityCost() { return electricityCost; }
    public void setElectricityCost(Double electricityCost) { this.electricityCost = electricityCost; }
    public Double getWaterCost() { return waterCost; }
    public void setWaterCost(Double waterCost) { this.waterCost = waterCost; }
    public Double getCommonFee() { return commonFee; }
    public void setCommonFee(Double commonFee) { this.commonFee = commonFee; }
    public Double getElevatorMaintenanceFee() { return elevatorMaintenanceFee; }
    public void setElevatorMaintenanceFee(Double elevatorMaintenanceFee) { this.elevatorMaintenanceFee = elevatorMaintenanceFee; }
    public Double getParkingFee() { return parkingFee; }
    public void setParkingFee(Double parkingFee) { this.parkingFee = parkingFee; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
    public LocalDate getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDate paidAt) { this.paidAt = paidAt; }
}
