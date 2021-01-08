package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Relations
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "teacher")
    private List<AssistanceSheet> assistanceSheets;

    public Teacher() {
    }

    public Teacher(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AssistanceSheet> getAssistanceSheets() {
        return assistanceSheets;
    }

    public void setAssistanceSheets(List<AssistanceSheet> assistanceSheets) {
        this.assistanceSheets = assistanceSheets;
    }
}
