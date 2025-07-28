package com.example.accessingdatajpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Flat")
@Entity
public class Flat {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name = "firstname")
  private String firstName;
  @Column(name = "lastname")
  private String lastName;
  @Column(name = "phone")
  private String phone;
  protected Flat() {}

  public Flat(String firstName, String lastName, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return String.format(
        "Flat[id=%d, firstName='%s', lastName='%s', phone='%s']",
        id, firstName, lastName, phone);
  }

  public void setName(String n) {
    this.firstName = n;
  }
  public Long getId() {
    return id;
  }

  public String getfirstName() {
    return firstName;
  }

  public String getlastName() {
    return lastName;
  }
}
