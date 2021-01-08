package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.Formation;
import com.iut.assistance.production.models.entities.Semestre;

import java.util.List;

public interface SemestreService {

    Semestre findBySemestre(Integer semestre);

    List<Semestre> findByFormation(Formation formation);
}
