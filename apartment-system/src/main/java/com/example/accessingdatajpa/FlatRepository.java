package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FlatRepository extends CrudRepository<Flat, Long> {
  List<Flat> findByLastName(String lastName);

  Flat findById(long id);
}