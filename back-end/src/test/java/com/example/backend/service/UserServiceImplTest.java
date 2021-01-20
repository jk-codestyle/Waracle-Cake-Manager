package com.example.backend.service;

import com.example.backend.domain.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    protected UserService userService;

    @Test
    void shouldReturnOptionalUser() {
        Optional<User> userByEmail = userService.findByEmail("user@mail.ru");
        assertThat(Optional.of(userByEmail)).isNotNull();
    }
}