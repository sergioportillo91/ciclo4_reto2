package com.example.ciclo4_reto2.controller;

import com.example.ciclo4_reto2.model.User;
import com.example.ciclo4_reto2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return  userService.registrar(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userService.delete(id);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticar(@PathVariable("email") String email,@PathVariable("password") String password){
        return userService.autenticarUsuario(email,password);
    }
}
