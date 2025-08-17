package com.example.apartmentsystem.dto.request;

import lombok.Data;

@Data
public class ResidentRequest {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String identityCard;   // CMT/CCCD
    private Integer birthYear;
    private String gender;
    private Long apartmentId;      // ID căn hộ cư dân đang ở
}
