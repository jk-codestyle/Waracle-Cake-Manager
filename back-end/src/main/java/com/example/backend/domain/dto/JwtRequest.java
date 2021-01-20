package com.example.backend.domain.dto;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 779662560310771145L;
    private String email;
    private String password;

    //region Constructors
    public JwtRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public JwtRequest() {
    }
    //endregion

    //region Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion
}
