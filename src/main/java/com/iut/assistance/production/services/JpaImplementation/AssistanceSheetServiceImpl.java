package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.repositories.AssistanceSheetRepository;
import com.iut.assistance.production.services.AssistanceSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssistanceSheetServiceImpl implements AssistanceSheetService {

    @Autowired private AssistanceSheetRepository repository;

    @Override
    public AssistanceSheet createAssistanceSheet(AssistanceSheet sheet) {
        return repository.save(sheet);
    }

    @Override
    public AssistanceSheet findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
