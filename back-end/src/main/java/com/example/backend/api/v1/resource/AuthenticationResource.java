package com.example.backend.api.v1.resource;

import com.example.backend.domain.dto.JwtRequest;
import com.example.backend.domain.model.User;
import com.example.backend.exceptions.UserNotFountException;
import com.example.backend.security.jwt.JwtTokenProvider;
import com.example.backend.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(AuthenticationResource.BASE_URL)
public class AuthenticationResource {

    public static final String BASE_URL = "/api/v1/auth";

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;


    public AuthenticationResource(AuthenticationManager authenticationManager, UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody JwtRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Optional<User> user = userService.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFountException("User with email: " + email + " not found");
        }
        return jwtTokenProvider.createToken(user.get());
    }
}
