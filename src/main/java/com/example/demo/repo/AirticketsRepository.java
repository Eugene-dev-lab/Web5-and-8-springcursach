package com.example.demo.repo;

import com.example.demo.models.Airtickets;
import org.springframework.data.repository.CrudRepository;

public interface AirticketsRepository extends CrudRepository<Airtickets, Long> {
}
