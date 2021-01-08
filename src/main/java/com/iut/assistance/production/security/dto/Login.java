package com.iut.assistance.production.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Login {

    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
