package com.mongo.mongotest.services;

import com.mongo.mongotest.entities.User;
import com.mongo.mongotest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User update(Long id, User user) {
        return repository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    return repository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
