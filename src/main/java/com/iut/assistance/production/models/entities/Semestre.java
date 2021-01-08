package com.iut.assistance.production.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semestres")
public class Semestre {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer semestre;

//    RELATIONS
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @JsonBackReference
    @OneToMany(mappedBy = "semestre", fetch = FetchType.EAGER)
    private List<Group> groupList;

    @JsonBackReference
    @OneToMany(mappedBy = "semestre")
    private List<Module> moduleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }
}
