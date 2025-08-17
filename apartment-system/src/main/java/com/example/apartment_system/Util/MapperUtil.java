package com.example.apartmentsystem.Util;

import com.example.apartmentsystem.dto.request.ApartmentRequest;
import com.example.apartmentsystem.dto.request.ResidentRequest;
import com.example.apartmentsystem.dto.response.ApartmentResponse;
import com.example.apartmentsystem.dto.response.ResidentResponse;
import com.example.apartmentsystem.model.Apartment;
import com.example.apartmentsystem.model.Resident;

public class MapperUtil {

    // Entity -> DTO
    public static ApartmentResponse toApartmentResponse(Apartment apartment) {
        return new ApartmentResponse(
                apartment.getId(),
                apartment.getName(),
                apartment.getArea(),
                apartment.getRoomCount(),
                apartment.getEmail()
        );
    }

    public static ResidentResponse toResidentResponse(Resident resident) {
        return new ResidentResponse(
                resident.getId(),
                resident.getName(),
                resident.getEmail(),
                resident.getPhone(),
                resident.getNationalId(),
                resident.getYearOfBirth(),
                resident.getGender(),
                resident.getApartment() != null ? resident.getApartment().getId() : null
        );
    }

    // DTO -> Entity
    public static Apartment toApartmentEntity(ApartmentRequest request) {
        Apartment apartment = new Apartment();
        apartment.setName(request.getName());
        apartment.setArea(request.getArea());
        apartment.setRoomCount(request.getRoomCount());
        apartment.setEmail(request.getEmail());
        return apartment;
    }

    public static Resident toResidentEntity(ResidentRequest request) {
        Resident resident = new Resident();
        resident.setName(request.getName());
        resident.setEmail(request.getEmail());
        resident.setPhone(request.getPhone());
        resident.setNationalId(request.getNationalId());
        resident.setYearOfBirth(request.getYearOfBirth());
        resident.setGender(request.getGender());
        return resident;
    }
}
