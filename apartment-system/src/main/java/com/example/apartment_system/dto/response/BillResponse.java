package com.example.apartmentsystem.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BillResponse {
    private Long id;
    private String apartmentNumber;
    private Double electricityUsage;
    private Double waterUsage;
    private Double otherFees;
    private Double totalAmount;   // Tổng tiền cần thanh toán
    private LocalDate dueDate;
    private String paymentStatus; // Paid / Unpaid
}
