package com.example.backend.domain.dto;

import java.io.Serializable;

public class JwtToken implements Serializable {

    private static final long serialVersionUID = 4556537763892265676L;
    private final String jwtToken;

    public JwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
