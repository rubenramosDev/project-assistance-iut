package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.AssistanceSheet;

public interface AssistanceSheetService {

    public AssistanceSheet findById(Long id);

    public AssistanceSheet createAssistanceSheet(AssistanceSheet sheet);

}
