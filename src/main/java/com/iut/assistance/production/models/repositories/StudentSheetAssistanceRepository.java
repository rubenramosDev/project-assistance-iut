package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.StudentSheetAssistance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentSheetAssistanceRepository extends CrudRepository<StudentSheetAssistance, Long> {

    List<StudentSheetAssistance> findByStudent(Student student);

    List<StudentSheetAssistance> findByAssistanceSheet(AssistanceSheet assistanceSheet);

}