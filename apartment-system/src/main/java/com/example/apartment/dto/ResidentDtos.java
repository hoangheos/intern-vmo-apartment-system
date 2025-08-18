package com.example.apartment.dto;

import com.example.apartment.domain.Gender;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ResidentDtos {
    public record CreateOrUpdate(
        @NotBlank String name,
        @jakarta.validation.constraints.Email String email,
        String phone,
        String idCard,
        Integer birthYear,
        Gender gender,
        boolean active,
        LocalDate moveInDate,
        LocalDate moveOutDate,
        Long apartmentId
    ) {}
}
