package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Formation;
import com.iut.assistance.production.models.entities.Semestre;
import com.iut.assistance.production.models.repositories.SemestreRepository;
import com.iut.assistance.production.services.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SemestreServiceImpl implements SemestreService {

    @Autowired private SemestreRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Semestre findBySemestre(Integer semestre) {
        return repository.findBySemestre(semestre);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Semestre> findByFormation(Formation formation){
        return repository.findByFormation(formation);
    }
}
