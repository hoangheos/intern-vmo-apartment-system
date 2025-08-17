package com.example.apartmentsystem.dto.response;

import lombok.Data;

@Data
public class ResidentResponse {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String identityCard;
    private Integer birthYear;
    private String gender;
    private String apartmentNumber; // Trả về số căn hộ
}
