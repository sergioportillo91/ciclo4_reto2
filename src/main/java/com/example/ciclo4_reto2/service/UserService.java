package com.example.ciclo4_reto2.service;

import com.example.ciclo4_reto2.model.User;
import com.example.ciclo4_reto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);

    }
    public User registrar(User user){
        if(user.getId()==null){

            return user;

        } else {
            Optional<User> u = userRepository.getUser(user.getId());
            if(u.isEmpty()) {
                if(existeEmail(user.getEmail())==false) {
                    return userRepository.save(user);
                }else {
                    return user;
                }
            } else {
            return user;
            }
        }
    }
    public User update(User u){
        if(u.getId()!=null){
            Optional<User> g= userRepository.getUser(u.getId());
            if(!g.isEmpty()){
                if(u.getName()!=null){
                    g.get().setName(u.getName());
                }if(u.getIdentification()!=null){
                    g.get().setIdentification(u.getIdentification());
                }if(u.getEmail()!=null){
                    g.get().setEmail(u.getEmail());
                }if(u.getAddress()!=null){
                    g.get().setAddress(u.getAddress());
                }if(u.getType()!=null){
                    g.get().setType(u.getType());
                }if(u.getZone()!=null){
                    g.get().setZone(u.getZone());
                }if(u.getPassword()!=null){
                    g.get().setPassword(u.getPassword());
                }if(u.getCellPhone()!=null){
                    g.get().setCellPhone(u.getCellPhone());
                }
                return userRepository.save(g.get());

            }
        }
        return u;

    }
    public boolean delete(int id){
        Optional<User> c=getUser(id);
        if(!c.isEmpty()){
            userRepository.delete(c.get());
            return true;
        }
        return false;

    }
    public Boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }
    public User autenticarUsuario(String email,String password){
        Optional<User> usuario = userRepository.autenticaUsuario(email,password);
        if(usuario.isEmpty()){
            return new User();
        } else {
            return usuario.get();
        }
    }
}
