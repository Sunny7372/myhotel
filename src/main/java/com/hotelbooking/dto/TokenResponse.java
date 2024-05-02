package com.hotelbooking.dto;

public class TokenResponse {
    private String tokentype="Bearer";
    private String token;

    public String getTokentype() {
        return tokentype;
    }

    public void setTokentype(String tokentype) {
        this.tokentype = tokentype;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
