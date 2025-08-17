package com.example.apartmentsystem.dto.request;

import lombok.Data;

@Data
public class EmailRequest {
    private String to;        // Người nhận
    private String subject;   // Chủ đề
    private String body;      // Nội dung email
}
