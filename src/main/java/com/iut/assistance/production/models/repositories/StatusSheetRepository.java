package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.StatusSheet;
import org.springframework.data.repository.CrudRepository;

public interface StatusSheetRepository extends CrudRepository<StatusSheet, Long>{

    StatusSheet findByCode(String code);

}