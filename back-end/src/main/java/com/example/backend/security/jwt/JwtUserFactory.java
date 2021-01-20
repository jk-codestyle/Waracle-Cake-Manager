package com.example.backend.security.jwt;

import com.example.backend.domain.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class JwtUserFactory {
    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser
                .JwtUserBuilder()
                .id(user.getEmployeeId())
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString())))
                .build();
    }
}
