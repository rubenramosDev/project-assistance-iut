package com.iut.assistance.production.models.dto;

import java.util.List;

public class SemestreDto {

        private Long id;
        private Integer semestre;
        private List<GroupDto> group;
        private List<ModuleDto> moduleDtos;


    public SemestreDto(Long id, Integer semestre) {
        this.id = id;
        this.semestre = semestre;
    }

    public SemestreDto(Long id, Integer semestre, List<GroupDto> group, List<ModuleDto> moduleDtos) {
        this.id = id;
        this.semestre = semestre;
        this.group = group;
        this.moduleDtos = moduleDtos;
    }

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

    public List<GroupDto> getGroup() {
        return group;
    }

    public void setGroup(List<GroupDto> group) {
        this.group = group;
    }

    public List<ModuleDto> getModuleDtos() {
        return moduleDtos;
    }

    public void setModuleDtos(List<ModuleDto> moduleDtos) {
        this.moduleDtos = moduleDtos;
    }
}
