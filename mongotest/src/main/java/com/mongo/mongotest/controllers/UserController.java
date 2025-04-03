package com.mongo.mongotest.controllers;

import com.mongo.mongotest.entities.User;
import com.mongo.mongotest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> buscarPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public User criar(@RequestBody User usuario) {
        return service.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}
