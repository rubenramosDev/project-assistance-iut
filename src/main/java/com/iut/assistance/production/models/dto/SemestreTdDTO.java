package com.iut.assistance.production.models.dto;

public class SemestreTdDTO {

    private Integer semestre;
    private Integer TD;

    public SemestreTdDTO(Integer semestre, Integer TD) {
        this.semestre = semestre;
        this.TD = TD;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getTD() {
        return TD;
    }

    public void setTD(Integer TD) {
        this.TD = TD;
    }
}
