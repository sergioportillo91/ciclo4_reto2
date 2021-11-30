package com.example.ciclo4_reto2.repository;

import com.example.ciclo4_reto2.model.Supplements;
import com.example.ciclo4_reto2.model.User;
import com.example.ciclo4_reto2.repository.crud.SupplementsCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplementsRepository {

    @Autowired
    private SupplementsCrudRepository supplementsCrudRepository;

    public List<Supplements> getAll() {
        return (List<Supplements>) supplementsCrudRepository.findAll();
    }

    public Optional<Supplements> getReference(String reference) {
        return supplementsCrudRepository.findById(reference);
    }

    public Supplements save(Supplements supplements){
        return supplementsCrudRepository.save(supplements);
    }
    public void Update(Supplements supplements){
        supplementsCrudRepository.save(supplements);
    }
    public void delete(Supplements supplements){
        supplementsCrudRepository.delete(supplements);
    }


}
