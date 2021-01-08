package com.iut.assistance.production.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "modules")
public class Module {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double coefficient;
    private String code;
    private String codeApogee;
    private String ects;
    private Double heuresTp;
    private String abbrev;
    private Integer numero;
    private Double heuresCours;
    private Integer moduleType;

//    @Column(unique = true)
    private String titre;
    private Double heuresTd;

    //RELATIONS
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    @JsonBackReference
    @OneToMany(mappedBy = "module")
    private List<AssistanceSheet> assistanceSheets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeApogee() {
        return codeApogee;
    }

    public void setCodeApogee(String codeApogee) {
        this.codeApogee = codeApogee;
    }

    public String getEcts() {
        return ects;
    }

    public void setEcts(String ects) {
        this.ects = ects;
    }

    public Double getHeuresTp() {
        return heuresTp;
    }

    public void setHeuresTp(Double heuresTp) {
        this.heuresTp = heuresTp;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getHeuresCours() {
        return heuresCours;
    }

    public void setHeuresCours(Double heuresCours) {
        this.heuresCours = heuresCours;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Double getHeuresTd() {
        return heuresTd;
    }

    public void setHeuresTd(Double heuresTd) {
        this.heuresTd = heuresTd;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
}

