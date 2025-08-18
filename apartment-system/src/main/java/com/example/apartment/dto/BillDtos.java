package com.example.apartment.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class BillDtos {
    public record CreateOrUpdate(
        @NotNull Long apartmentId,
        @NotNull LocalDate billingMonth,
        @PositiveOrZero Double electricityKwh,
        @PositiveOrZero Double waterM3,
        @PositiveOrZero Double electricityCost,
        @PositiveOrZero Double waterCost,
        @PositiveOrZero Double commonFee,
        @PositiveOrZero Double elevatorMaintenanceFee,
        @PositiveOrZero Double parkingFee,
        LocalDate dueDate,
        boolean paid
    ) {}
}
