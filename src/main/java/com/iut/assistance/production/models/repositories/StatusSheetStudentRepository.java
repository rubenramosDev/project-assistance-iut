package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.StatusSheetStudent;
import org.springframework.data.repository.CrudRepository;

public interface StatusSheetStudentRepository extends CrudRepository<StatusSheetStudent, Long>{

    StatusSheetStudent findByCode(String code);

}