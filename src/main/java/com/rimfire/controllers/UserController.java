package com.rimfire.controllers;

import com.rimfire.entities.User;
import com.rimfire.repositories.UserRepository;

import io.micronaut.data.exceptions.DataAccessException;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExecuteOn(TaskExecutors.IO)
@Controller("/users")
public class UserController {
    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Get("/")
    public Iterable<User> index() {
        return userRepository.findAll();
    }
    
    @Get("/{id}")
    public Optional<User> show(UUID id) {
        return userRepository.findById(id);
    }
    
    @Post("/")
    public User create(@Body User user) {
        return userRepository.save(user);
    }
    
    @Put("/{id}")
    public User update(UUID id, @Body User user) {
        // Since records are immutable, create a new instance with the desired values
        User updatedUser = new User(id, user.username(), user.password());
        return userRepository.update(updatedUser);
    }
    
    @Delete("/{id}")
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}