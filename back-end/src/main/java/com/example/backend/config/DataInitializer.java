package com.example.backend.config;

import com.example.backend.domain.model.Cake;
import com.example.backend.domain.model.Role;
import com.example.backend.domain.model.User;
import com.example.backend.repository.CakeRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

import static com.example.backend.config.Constants.JSON_CAKE_URL;

@Component
public class DataInitializer {

    private final RestTemplate restTemplate;

    private final CakeRepository cakeRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final static String PATH = JSON_CAKE_URL;

    public DataInitializer(RestTemplate restTemplate, CakeRepository cakeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.restTemplate = restTemplate;
        this.cakeRepository = cakeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        ResponseEntity<List<Cake>> responseEntity =
                restTemplate.exchange(
                        PATH,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );
        List<Cake> cakes;
        if (!Objects.requireNonNull(responseEntity.getBody()).isEmpty()) {
            cakes = responseEntity.getBody();
            cakes.forEach(cakeRepository::save);
        }
    }

    @PostConstruct
    public void initUsers() {
        User user = new User();
        user.setEmail("user@baker.me");
        user.setPassword(passwordEncoder.encode("1"));
        user.setRole(Role.ROLE_EMPLOYEE);

        userRepository.save(user);

    }
}
