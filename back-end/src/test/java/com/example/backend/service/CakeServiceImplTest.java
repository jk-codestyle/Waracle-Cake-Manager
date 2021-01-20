package com.example.backend.service;

import com.example.backend.domain.model.Cake;
import com.example.backend.repository.CakeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class CakeServiceImplTest {
    @Autowired
    protected CakeRepository cakeRepository;

    @Test
    void shouldInsertCakeInDatabaseAndGenerateId() {
        List<Cake> allCakes = cakeRepository.findAll();
        int quantityOfCakesStoredInDb = allCakes.size();

        Cake cake = new Cake("newCake", "description for new cake", "image url");
        cakeRepository.save(cake);

        assertThat(cakeRepository.findAll().size()).isEqualTo(quantityOfCakesStoredInDb + 1);
        assertThat(cake.getId()).isNotNull();
    }

}