package com.example.backend.service;

import com.example.backend.domain.dto.CakeDto;
import com.example.backend.domain.model.Cake;

import java.util.List;

public interface CakeService {
    List<Cake> getAll();
    Cake save(CakeDto cakeDto);
}
