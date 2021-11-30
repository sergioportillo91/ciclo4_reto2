package com.example.ciclo4_reto2.repository;

import com.example.ciclo4_reto2.model.User;
import com.example.ciclo4_reto2.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    public User save(User u){
        return userCrudRepository.save(u);
    }
    public void Update(User user){
        userCrudRepository.save(user);
    }
    public void delete(User user){
        userCrudRepository.delete(user);
    }
    public boolean existeEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    public Optional<User> autenticaUsuario(String email,String password){
        return userCrudRepository.findByEmailAndPassword(email,password);
    }
}
