package com.iut.assistance.production.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //    RELATIONS
    @JsonBackReference
    @OneToMany(mappedBy = "group")
    private List<AssistanceSheet> assistanceSheets;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<AssistanceSheet> getAssistanceSheets() {
        return assistanceSheets;
    }

    public void setAssistanceSheets(List<AssistanceSheet> assistanceSheets) {
        this.assistanceSheets = assistanceSheets;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}
