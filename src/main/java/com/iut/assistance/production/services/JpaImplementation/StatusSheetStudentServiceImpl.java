package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.StatusSheetStudent;
import com.iut.assistance.production.models.repositories.StatusSheetStudentRepository;
import com.iut.assistance.production.services.StatusSheetStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatusSheetStudentServiceImpl implements StatusSheetStudentService {

    @Autowired private StatusSheetStudentRepository repository;

    @Override
    public StatusSheetStudent findByCode(String code) {
        return repository.findByCode(code);
    }
}
