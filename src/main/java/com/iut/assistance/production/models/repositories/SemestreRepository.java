package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.Formation;
import com.iut.assistance.production.models.entities.Semestre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SemestreRepository extends CrudRepository<Semestre, Long> {

    Semestre findBySemestre(Integer semestre);

    List<Semestre> findByFormation(Formation formation);
}
