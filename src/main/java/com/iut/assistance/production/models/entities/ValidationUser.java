package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "validation_users")
public class ValidationUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailConfirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date emailConfirmationTime;

    private String passwordForgetToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordForgetTime;

    //Relations
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public ValidationUser() {
    }

    public ValidationUser(String emailConfirmationToken, Date emailConfirmationTime, User user) {
        this.emailConfirmationToken = emailConfirmationToken;
        this.emailConfirmationTime = emailConfirmationTime;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailConfirmationToken() {
        return emailConfirmationToken;
    }

    public void setEmailConfirmationToken(String emailConfirmationToken) {
        this.emailConfirmationToken = emailConfirmationToken;
    }

    public Date getEmailConfirmationTime() {
        return emailConfirmationTime;
    }

    public void setEmailConfirmationTime(Date emailConfirmationTime) {
        this.emailConfirmationTime = emailConfirmationTime;
    }

    public String getPasswordForgetToken() {
        return passwordForgetToken;
    }

    public void setPasswordForgetToken(String passwordForgetToken) {
        this.passwordForgetToken = passwordForgetToken;
    }

    public Date getPasswordForgetTime() {
        return passwordForgetTime;
    }

    public void setPasswordForgetTime(Date passwordForgetTime) {
        this.passwordForgetTime = passwordForgetTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
