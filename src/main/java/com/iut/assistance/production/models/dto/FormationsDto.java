package com.iut.assistance.production.models.dto;

import com.iut.assistance.production.models.entities.Group;
import com.iut.assistance.production.models.entities.Semestre;

import java.util.ArrayList;
import java.util.List;

public class FormationsDto {

    private String id;
    private String name;
    private List<SemestreDto> semestreDtos = new ArrayList<>();

    public FormationsDto(String id, String name, List<Semestre> semestreList) {
        this.id = id;
        this.name = name;
        for (Semestre semestre : semestreList) {
            semestreDtos.add(new SemestreDto(semestre.getId(), semestre.getSemestre(), semestre.getGroupList()));
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SemestreDto> getSemestreDtos() {
        return semestreDtos;
    }

    class SemestreDto {
        private Long id;
        private Integer semestre;
        private List<GroupDto> group = new ArrayList<>();
        private List<ModuleDto> moduleDtos;

        public SemestreDto(Long id, Integer semestre, List<Group> group) {
            this.id = id;
            this.semestre = semestre;
            for (Group g : group) {
                this.group.add(new GroupDto(g.getId(), g.getName()));
            }
//            this.moduleDtos = moduleDtos;
        }

        class GroupDto {
            private Long id;
            private String group;

            public GroupDto(Long id, String group) {
                this.id = id;
                this.group = group;
            }
        }

        class ModuleDto {
            private Long id;
            private String titre;
        }

    }
}



