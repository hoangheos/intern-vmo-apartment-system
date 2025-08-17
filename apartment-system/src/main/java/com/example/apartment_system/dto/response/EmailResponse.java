package com.example.apartmentsystem.dto.response;

import lombok.Data;

@Data
public class EmailResponse {
    private String to;
    private String subject;
    private String status; // SUCCESS / FAILED
}
