package com.example.demo.repo;

import com.example.demo.models.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Long> {
}
