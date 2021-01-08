package com.iut.assistance.production.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserDto {

    @NotEmpty(message = "{email.NotEmpty}")
    @Email(message = "{email.NotCorrect}")
    @Column(unique = true)
//    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String email;

    @NotBlank(message = "{name.NotBlank}")
    private String name;

    @NotBlank(message = "{lastName.NotBlank}")
    private String lastName;

    @NotBlank(message = "{password.NotBlank}")
    @Size(min = 8, message = "Must have at least 8 charcaters")
    private String password;

    @NotBlank(message = "{identifierNumber.NotBlank}")
    private String identifierNumber;

    private Integer statusUser;

    public UserDto() {
    }

    public UserDto(@NotEmpty(message = "{email.NotEmpty}") @Email(message = "{email.NotCorrect}") String email, @NotBlank(message = "{name.NotBlank}") String name, @NotBlank(message = "{lastName.NotBlank}") String lastName, @NotBlank(message = "{password.NotBlank}") @Size(min = 8, message = "Must have at least 8 charcaters") String password, @NotBlank(message = "{identifierNumber.NotBlank}") String identifierNumber, Integer statusUser) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.identifierNumber = identifierNumber;
        this.statusUser = statusUser;
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

    public Integer getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(Integer statusUser) {
        this.statusUser = statusUser;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }
}
