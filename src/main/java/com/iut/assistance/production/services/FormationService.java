package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.Formation;

import java.util.List;

public interface FormationService {

    public List<Formation> getAll();

    public Formation save(Formation formation);

    public Formation findById(String id);

}
