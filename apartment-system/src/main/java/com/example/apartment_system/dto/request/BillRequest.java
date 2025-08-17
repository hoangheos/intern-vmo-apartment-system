package com.example.apartmentsystem.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BillRequest {
    private Long apartmentId;
    private Double electricityUsage; // Số điện kWh
    private Double waterUsage;       // Số nước m3
    private Double otherFees;        // Các phí khác (vệ sinh, gửi xe…)
    private LocalDate dueDate;       // Ngày thanh toán
}
