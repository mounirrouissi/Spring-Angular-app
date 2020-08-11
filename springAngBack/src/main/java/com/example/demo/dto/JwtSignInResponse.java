package com.example.demo.dto;

public class JwtSignInResponse {
    public String getJwt() {
        return jwt;
    }


    public JwtSignInResponse(String jwt) {
        this.jwt = jwt;
    }


    public String jwt;
}
