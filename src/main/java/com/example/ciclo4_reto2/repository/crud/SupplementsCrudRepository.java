package com.example.ciclo4_reto2.repository.crud;

import com.example.ciclo4_reto2.model.Supplements;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplementsCrudRepository extends MongoRepository<Supplements,String> {
}
