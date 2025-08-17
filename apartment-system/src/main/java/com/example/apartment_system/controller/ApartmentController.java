package com.example.apartmentsystem.controller;

import com.example.apartmentsystem.dto.request.ApartmentRequest;
import com.example.apartmentsystem.dto.response.ApartmentResponse;
import com.example.apartmentsystem.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentService apartmentService;

    // Lấy danh sách căn hộ
    @GetMapping
    public ResponseEntity<List<ApartmentResponse>> getAllApartments() {
        return ResponseEntity.ok(apartmentService.getAllApartments());
    }

    // Lấy chi tiết căn hộ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ApartmentResponse> getApartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(apartmentService.getApartmentById(id));
    }

    // Thêm mới căn hộ
    @PostMapping
    public ResponseEntity<ApartmentResponse> createApartment(@RequestBody ApartmentRequest request) {
        return ResponseEntity.ok(apartmentService.createApartment(request));
    }

    // Cập nhật căn hộ
    @PutMapping("/{id}")
    public ResponseEntity<ApartmentResponse> updateApartment(
            @PathVariable Long id,
            @RequestBody ApartmentRequest request) {
        return ResponseEntity.ok(apartmentService.updateApartment(id, request));
    }

    // Xóa căn hộ
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApartment(@PathVariable Long id) {
        apartmentService.deleteApartment(id);
        return ResponseEntity.ok("Apartment deleted successfully");
    }
}
