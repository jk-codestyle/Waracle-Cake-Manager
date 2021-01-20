package com.example.backend.service;

import com.example.backend.domain.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
