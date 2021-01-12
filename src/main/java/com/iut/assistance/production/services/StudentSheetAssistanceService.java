package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.entities.StudentSheetAssistance;

import java.util.List;

public interface StudentSheetAssistanceService {

    public StudentSheetAssistance findById(Long id);

    public List<StudentSheetAssistance> findByAssistanceSheet(AssistanceSheet assistanceSheet);

    public StudentSheetAssistance save(StudentSheetAssistance studentSheetAssistance);

    public void deleteById(Long id);
}
