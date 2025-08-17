package com.example.apartmentsystem.controller;

import com.example.apartmentsystem.dto.request.BillRequest;
import com.example.apartmentsystem.dto.response.BillResponse;
import com.example.apartmentsystem.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    // Lấy danh sách hóa đơn
    @GetMapping
    public ResponseEntity<List<BillResponse>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    // Lấy chi tiết hóa đơn theo ID
    @GetMapping("/{id}")
    public ResponseEntity<BillResponse> getBillById(@PathVariable Long id) {
        return ResponseEntity.ok(billService.getBillById(id));
    }

    // Tạo hóa đơn mới
    @PostMapping
    public ResponseEntity<BillResponse> createBill(@RequestBody BillRequest request) {
        return ResponseEntity.ok(billService.createBill(request));
    }

    // Cập nhật hóa đơn
    @PutMapping("/{id}")
    public ResponseEntity<BillResponse> updateBill(
            @PathVariable Long id,
            @RequestBody BillRequest request) {
        return ResponseEntity.ok(billService.updateBill(id, request));
    }

    // Xóa hóa đơn
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully");
    }
}
