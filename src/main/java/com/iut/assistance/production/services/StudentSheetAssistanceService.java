package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.StudentSheetAssistance;

public interface StudentSheetAssistanceService {

    public StudentSheetAssistance findById(Long id);

    public StudentSheetAssistance save(StudentSheetAssistance studentSheetAssistance);

    public void deleteById(Long id);
}
