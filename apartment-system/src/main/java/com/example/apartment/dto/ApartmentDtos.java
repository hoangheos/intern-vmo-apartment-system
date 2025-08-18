package com.example.apartment.dto;

import jakarta.validation.constraints.*;
public class ApartmentDtos {
    public record CreateOrUpdate(
        @NotBlank String number,
        @Positive Double area,
        @Positive Integer rooms,
        String phone,
        @jakarta.validation.constraints.Email String email
    ){}
}
