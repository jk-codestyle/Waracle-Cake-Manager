package com.example.frontend.service;

import com.example.frontend.dto.JwtRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.frontend.config.Constants.Endpoints.JWT_AUTH;

@FeignClient(name = "feignJwtRequest", url = JWT_AUTH)
public interface FeignJwtRequest {

    @PostMapping
    String getJwtToken(@RequestBody JwtRequest jwtRequest);
}
