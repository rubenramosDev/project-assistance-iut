package com.iut.assistance.production.facade;

import com.iut.assistance.production.models.dto.FormationsDto;
import com.iut.assistance.production.models.entities.Formation;
import com.iut.assistance.production.services.FormationService;
import com.iut.assistance.production.services.ModuleService;
import com.iut.assistance.production.services.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FormationFacade {

    @Autowired private ModuleService    moduleService;
    @Autowired private FormationService formationService;
    @Autowired private SemestreService semestreService;

    public List<FormationsDto> getAll(){
        List<FormationsDto> formationsDtos = new ArrayList<>();

        List<Formation> formations = formationService.getAll();

        for(Formation formation : formations){
            formationsDtos.add(new FormationsDto(formation.getId(), formation.getTitre(), formation.getSemestres()));
        }
        return formationsDtos;
    }

}
