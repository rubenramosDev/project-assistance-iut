package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Formation;
import com.iut.assistance.production.models.repositories.FormationRepository;
import com.iut.assistance.production.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class FormationServiceImpl implements FormationService {

    @Autowired private FormationRepository repository;


    @Override
    public List<Formation> getAll() {
        return (List<Formation>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Formation findById(String id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Formation save(Formation formation) {
        return repository.save(formation);
    }


}
