package com.iut.assistance.production.models.dto;

import javax.validation.constraints.NotNull;

public class UserUpdateDto {

    @NotNull
    private String identifierNumber;

    private String email;

    private String name;

    private String lastName;

    private String password;

    public UserUpdateDto(@NotNull String identifierNumber, String email, @NotNull String name, @NotNull String lastName, String password) {
        this.identifierNumber = identifierNumber;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
