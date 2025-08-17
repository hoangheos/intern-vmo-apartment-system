package com.example.apartmentsystem.dto.response;

import lombok.Data;

@Data
public class ApartmentResponse {
    private Long id;
    private String apartmentNumber;
    private Integer floor;
    private Double area;
    private Integer rooms;
    private String ownerName; // Chủ hộ (nếu có)
}
