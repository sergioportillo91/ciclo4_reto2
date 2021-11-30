package com.example.ciclo4_reto2.service;


import com.example.ciclo4_reto2.model.Supplements;
import com.example.ciclo4_reto2.model.User;
import com.example.ciclo4_reto2.repository.SupplementsRepository;
import com.example.ciclo4_reto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class SupplementsService {

    @Autowired
    private SupplementsRepository supplementsRepository;

    public List<Supplements> getAll() {
        return supplementsRepository.getAll();
    }

    public Optional<Supplements> getReference(String reference){
        return supplementsRepository.getReference(reference);

    }

    public Supplements registrar(Supplements s) {
        if (s.getReference() == null) {
            return s;
        } else {
            return supplementsRepository.save(s);
        }
    }
    public Supplements update(Supplements u){
        if(u.getReference()!=null){
            Optional<Supplements> g= supplementsRepository.getReference(u.getReference());
            if(!g.isEmpty()){
                if(u.getBrand()!=null){
                    g.get().setBrand(u.getBrand());
                }if(u.getCategory()!=null){
                    g.get().setCategory(u.getCategory());
                }if(u.getDescription()!=null){
                    g.get().setDescription(u.getDescription());
                }if(u.getObjetivo()!=null){
                    g.get().setObjetivo(u.getObjetivo());
                }if(u.getPhotography()!=null){
                    g.get().setPhotography(u.getPhotography());
                }
                return supplementsRepository.save(g.get());

            }
        }
        return u;

    }
    public boolean delete(String id){
        Optional<Supplements> c=getReference(id);
        if(!c.isEmpty()){
            supplementsRepository.delete(c.get());
            return true;
        }
        return false;

    }



}
