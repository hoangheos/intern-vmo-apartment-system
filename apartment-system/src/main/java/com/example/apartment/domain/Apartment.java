package com.example.apartment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String number; // e.g. A-101

    @Positive
    private Double area; // m2

    @Positive
    private Integer rooms;

    private String phone;
    @Email private String email;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Resident> residents = new ArrayList<>();

    // getters & setters
    public Long getId() { return id; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }
    public Integer getRooms() { return rooms; }
    public void setRooms(Integer rooms) { this.rooms = rooms; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Resident> getResidents() { return residents; }
    public void setResidents(List<Resident> residents) { this.residents = residents; }
}
