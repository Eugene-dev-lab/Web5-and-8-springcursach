package com.example.demo.repo;

import com.example.demo.models.Tours;
import org.springframework.data.repository.CrudRepository;

public interface ToursRepository extends CrudRepository<Tours, Long> {
}
