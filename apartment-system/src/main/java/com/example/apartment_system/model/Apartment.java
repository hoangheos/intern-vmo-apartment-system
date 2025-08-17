package com.example.apartmentsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "apartments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment_number", nullable = false, unique = true)
    private String apartmentNumber;

    @Column(name = "floor", nullable = false)
    private int floor;

    @Column(name = "area", nullable = false)
    private double area;

    // Một căn hộ có thể có nhiều cư dân
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resident> residents;

    // Một căn hộ có thể có nhiều hóa đơn
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bill> bills;
}
