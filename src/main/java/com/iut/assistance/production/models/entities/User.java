package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{email.NotEmpty}")
    @Email(message = "{email.NotCorrect}")
    @Column(unique = true)
    private String email;

    @NotNull
    @Column(unique = true)
    private String identifierNumber;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 8)
    private String password;

    //RELATIONS
    //Own
    @ManyToOne
    @JoinColumn(name = "user_status_id", referencedColumnName = "id")
    private StatusUser statusUser;

    @OneToOne(mappedBy = "user")
    private ValidationUser validationUser;

    @OneToOne(mappedBy = "user")
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    private Student student;

    @ManyToMany
    @JoinTable(
            name = "user_privileges",
            joinColumns        = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private Set<Privilege> privilegeList = new HashSet<>();

    public User() {

    }

    public User(@Email String email, @NotNull String identifierNumber, @NotNull String name, @NotNull String lastName, StatusUser statusUser) {
        this.email = email;
        this.identifierNumber = identifierNumber;
        this.name = name;
        this.lastName = lastName;
        this.statusUser = statusUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public StatusUser getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(StatusUser statusUser) {
        this.statusUser = statusUser;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ValidationUser getValidationUser() {
        return validationUser;
    }

    public void setValidationUser(ValidationUser validationUser) {
        this.validationUser = validationUser;
    }

    public String getIdentifierNumber() {
        return identifierNumber;
    }

    public void setIdentifierNumber(String identifierNumber) {
        this.identifierNumber = identifierNumber;
    }

    public Set<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(Set<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
