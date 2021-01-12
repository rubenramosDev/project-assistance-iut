package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.entities.Teacher;
import com.iut.assistance.production.models.repositories.AssistanceSheetRepository;
import com.iut.assistance.production.services.AssistanceSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssistanceSheetServiceImpl implements AssistanceSheetService {

    @Autowired private AssistanceSheetRepository repository;

    @Transactional(readOnly = true)
    @Override
    public AssistanceSheet findById(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AssistanceSheet> findByTeacher(Teacher teacher){
        return repository.findByTeacher(teacher);
    }

    @Override
    public AssistanceSheet saveAssistanceSheet(AssistanceSheet sheet) {
        return repository.save(sheet);
    }


}
