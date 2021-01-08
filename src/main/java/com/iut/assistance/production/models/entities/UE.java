package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "unites_enseignements")
@Entity
public class UE {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acronyme;
    private Integer isExternal;
    private String codeApogee;
    private Double ects;
    private String ueCode;
    private Integer numero;
    private String titre;
    private Integer type;

//    RELATIONS
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "ue")
    private List<Matiere> matiere;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public Integer getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(Integer isExternal) {
        this.isExternal = isExternal;
    }

    public String getCodeApogee() {
        return codeApogee;
    }

    public void setCodeApogee(String codeApogee) {
        this.codeApogee = codeApogee;
    }

    public Double getEcts() {
        return ects;
    }

    public void setEcts(Double ects) {
        this.ects = ects;
    }

    public String getUeCode() {
        return ueCode;
    }

    public void setUeCode(String ueCode) {
        this.ueCode = ueCode;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<Matiere> getMatiere() {
        return matiere;
    }

    public void setMatiere(List<Matiere> matiere) {
        this.matiere = matiere;
    }
}
