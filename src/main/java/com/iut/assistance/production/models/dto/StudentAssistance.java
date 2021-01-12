package com.iut.assistance.production.models.dto;

import java.util.Date;

public class StudentAssistance {

    private Long   id;
    private String firstName;
    private String lastName;
    private String identifierNumber;
    private Date   date;
    private String status;

    public StudentAssistance(Long id, String firstName, String lastName, String identifierNumber, Date date, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identifierNumber = identifierNumber;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
