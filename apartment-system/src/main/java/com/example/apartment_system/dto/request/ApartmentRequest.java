package com.example.apartmentsystem.dto.request;

import lombok.Data;

@Data
public class ApartmentRequest {
    private String apartmentNumber;   // Số căn hộ
    private Integer floor;            // Tầng
    private Double area;              // Diện tích m2
    private Integer rooms;            // Số phòng
}
