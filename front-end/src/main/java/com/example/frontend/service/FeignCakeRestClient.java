package com.example.frontend.service;

import com.example.frontend.dto.CakeDto;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

import static com.example.frontend.config.Constants.Endpoints.CAKE_RESOURCE;

@FeignClient(name = "feignCakeClient", url = CAKE_RESOURCE)
public interface FeignCakeRestClient {

    @GetMapping
    @Headers("Content-Type: application/json")
    List<CakeDto> getAllCakes(@RequestHeader("Authorization") String bearerToken);


    @PostMapping
    @Headers("Content-Type: application/json")
    void addNewCake(@RequestHeader("Authorization") String bearerToken, @RequestBody CakeDto cakeDto);
}
