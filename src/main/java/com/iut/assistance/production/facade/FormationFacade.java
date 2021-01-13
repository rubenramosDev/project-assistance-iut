package com.iut.assistance.production.facade;

import com.iut.assistance.production.models.dto.FormationsDto;
import com.iut.assistance.production.models.dto.GroupDto;
import com.iut.assistance.production.models.dto.ModuleDto;
import com.iut.assistance.production.models.dto.SemestreDto;
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
//            ArrayList<SemestreDto> semestreDtos = formation.getSemestres().stream().map(semestre -> new SemestreDto(semestre.getId(), semestre.getSemestre(), semestre.getGroupList().stream().map(group -> new GroupDto(group.getId(), group.getName())).collect(Collectors.toList()), semestre.getModuleList().stream().map(module -> new ModuleDto(module.getId(), module.getTitre())).collect(Collectors.toList()))).collect(Collectors.toCollection());

        for(Formation formation : formations){
            ArrayList<SemestreDto> semestreDtos = new ArrayList<>();
            ArrayList<ModuleDto>   moduleDtos   = new ArrayList<>();
            ArrayList<GroupDto>  groupDtos      = new ArrayList<>();


//            for(Semestre semestre : formation.getSemestres()){
//                semestreDtos.add(new SemestreDto(semestre.getId(),semestre.getSemestre()));
//                for(Module module : semestre.getModuleList()){
//                    moduleDtos.add(new ModuleDto(module.getId(), module.getTitre()));
//                }
//                for(Group group : semestre.getGroupList()){
//                    groupDtos.add(new GroupDto(group.getId(), group.getName()));
//                }
//            }

            formationsDtos.add(new FormationsDto(formation.getId(), formation.getTitre(), semestreDtos));
        }
        return formationsDtos;
    }

}


//            for(int i =0 ; i< formation.getSemestres().size(); i++){
//        semestreDtos.add(new SemestreDto(formation.getSemestres().get(i).getId(),formation.getSemestres().get(i).getSemestre()));
//        for(Module module : formation.getSemestres().get(i).getModuleList()){
//        moduleDtos.add(new ModuleDto(module.getId(), module.getTitre()));
//        }
//        for(Group group : formation.getSemestres().get(i).getGroupList()){
//        groupDtos.add(new GroupDto(group.getId(), group.getName()));
//        }
//
//        semestreDtos.get(i).setGroup(groupDtos);
//        semestreDtos.get(i).setModuleDtos(moduleDtos);
//        }
