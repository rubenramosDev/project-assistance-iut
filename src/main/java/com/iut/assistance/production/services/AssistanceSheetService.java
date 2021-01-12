package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.entities.Teacher;

import java.util.List;

public interface AssistanceSheetService {

    List<AssistanceSheet> findByTeacher(Teacher teacher);

    public AssistanceSheet findById(Long id);

    public AssistanceSheet saveAssistanceSheet(AssistanceSheet sheet);

}
