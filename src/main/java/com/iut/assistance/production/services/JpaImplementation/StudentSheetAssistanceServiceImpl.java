package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.AssistanceSheet;
import com.iut.assistance.production.models.entities.StudentSheetAssistance;
import com.iut.assistance.production.models.repositories.StudentSheetAssistanceRepository;
import com.iut.assistance.production.services.StudentSheetAssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentSheetAssistanceServiceImpl implements StudentSheetAssistanceService {

    @Autowired private StudentSheetAssistanceRepository repository;


    @Transactional(readOnly = true)
    @Override
    public StudentSheetAssistance findById(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentSheetAssistance> findByAssistanceSheet(AssistanceSheet assistanceSheet){
        return repository.findByAssistanceSheet(assistanceSheet);
    }

    @Transactional
    @Override
    public StudentSheetAssistance save(StudentSheetAssistance studentSheetAssistance){
        return repository.save(studentSheetAssistance);
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
