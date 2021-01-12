package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.entities.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssistanceSheetRepository extends CrudRepository<AssistanceSheet, Long> {

    List<AssistanceSheet> findByTeacher(Teacher teacher);

}