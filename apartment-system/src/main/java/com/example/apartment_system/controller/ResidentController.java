package com.example.apartmentsystem.controller;

import com.example.apartmentsystem.dto.request.ResidentRequest;
import com.example.apartmentsystem.dto.response.ResidentResponse;
import com.example.apartmentsystem.service.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
@RequiredArgsConstructor
public class ResidentController {

    private final ResidentService residentService;

    // Lấy danh sách cư dân
    @GetMapping
    public ResponseEntity<List<ResidentResponse>> getAllResidents() {
        return ResponseEntity.ok(residentService.getAllResidents());
    }

    // Lấy cư dân theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ResidentResponse> getResidentById(@PathVariable Long id) {
        return ResponseEntity.ok(residentService.getResidentById(id));
    }

    // Thêm cư dân
    @PostMapping
    public ResponseEntity<ResidentResponse> createResident(@RequestBody ResidentRequest request) {
        return ResponseEntity.ok(residentService.createResident(request));
    }

    // Cập nhật cư dân
    @PutMapping("/{id}")
    public ResponseEntity<ResidentResponse> updateResident(
            @PathVariable Long id,
            @RequestBody ResidentRequest request) {
        return ResponseEntity.ok(residentService.updateResident(id, request));
    }

    // Xóa cư dân
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResident(@PathVariable Long id) {
        residentService.deleteResident(id);
        return ResponseEntity.ok("Resident deleted successfully");
    }
}
