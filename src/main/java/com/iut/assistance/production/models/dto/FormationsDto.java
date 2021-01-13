package com.iut.assistance.production.models.dto;

import com.iut.assistance.production.models.entities.Semestre;

import java.util.ArrayList;
import java.util.List;

public class FormationsDto {

    private String id;
    private String name;
    private List<SemestreDto> semestreDtos = new ArrayList<>();

    public FormationsDto(String id, String name, List<SemestreDto> semestreDtos) {
        this.id = id;
        this.name = name;
        this.semestreDtos = semestreDtos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SemestreDto> getSemestreDtos() {
        return semestreDtos;
    }

    public void setSemestreDtos(List<SemestreDto> semestreDtos) {
        this.semestreDtos = semestreDtos;
    }
}



