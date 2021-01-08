package com.iut.assistance.production.security.dto;

public class JwtDto {

    private String token;
    private String firstname;
    private String lastName;

    public JwtDto(String token, String firstname, String lastName) {
        this.token = token;
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
