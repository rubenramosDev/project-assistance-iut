package com.iut.assistance.production.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    private String id;
    private String acronyme;
    private String codeSpecialite;
    private Integer typeParcours;
    private String formationCode;
    private String titreOfficiel;
    private Integer version;
    private String titre;

//    RELATIONS
    @OneToMany(mappedBy = "formation")
    private List<UE> ue;

    @OneToMany(mappedBy = "formation")
    private List<Semestre> semestres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public String getCodeSpecialite() {
        return codeSpecialite;
    }

    public void setCodeSpecialite(String codeSpecialite) {
        this.codeSpecialite = codeSpecialite;
    }

    public Integer getTypeParcours() {
        return typeParcours;
    }

    public void setTypeParcours(Integer typeParcours) {
        this.typeParcours = typeParcours;
    }

    public String getTitreOfficiel() {
        return titreOfficiel;
    }

    public void setTitreOfficiel(String titreOfficiel) {
        this.titreOfficiel = titreOfficiel;
    }

    public String getFormationCode() {
        return formationCode;
    }

    public void setFormationCode(String formationCode) {
        this.formationCode = formationCode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<UE> getUe() {
        return ue;
    }

    public void setUe(List<UE> ue) {
        this.ue = ue;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }
}
