package com.example.backend.security;

import com.example.backend.domain.model.User;
import com.example.backend.exceptions.UserNotFountException;
import com.example.backend.security.jwt.JwtUserFactory;
import com.example.backend.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserServiceImpl userService;

    public JwtUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) {
        Optional<User> user = userService.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFountException("User with email: " + email + "not found");
        }
        log.info("User with email: {} successfully loaded", email);
        return JwtUserFactory.create(user.get());
    }
}
