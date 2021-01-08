package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matiers")
public class Matiere {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private Integer numero;

    public Matiere() {
    }

    //    RELATIONS
    @ManyToOne
    @JoinColumn(name = "unite_enseignement_id")
    private UE ue;

    @OneToMany(mappedBy = "matiere")
    private List<Module> modules;

    public Matiere(List<Module> modules) {
        this.modules = modules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public List<Module> getModules() {
        return modules;
    }
}
