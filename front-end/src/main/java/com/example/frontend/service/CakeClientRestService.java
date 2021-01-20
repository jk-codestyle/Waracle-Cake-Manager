package com.example.frontend.service;

import com.example.frontend.dto.CakeDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static com.example.frontend.config.Constants.Endpoints.CAKE_RESOURCE;

@Service
public class CakeClientRestService {

    private final RestTemplate restTemplate;

    public CakeClientRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CakeDto> getAllCakes() {
        ResponseEntity<List<CakeDto>> responseEntity =
                restTemplate.exchange(
                        CAKE_RESOURCE,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        }
                );

        return responseEntity.getBody() != null? responseEntity.getBody() :
                Collections.emptyList();
    }

    public void addNewCake(CakeDto cakeDto) {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<CakeDto> entity = new HttpEntity<>(cakeDto, headers);
        restTemplate.postForEntity(CAKE_RESOURCE, entity, CakeDto.class);
    }
}
