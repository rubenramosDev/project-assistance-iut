package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.StatusSheet;
import com.iut.assistance.production.models.repositories.StatusSheetRepository;
import com.iut.assistance.production.services.StatusSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StatusSheetServiceImpl implements StatusSheetService {

    @Autowired private StatusSheetRepository repository;

    @Transactional(readOnly = true)
    @Override
    public StatusSheet findByCode(String code) {
        return repository.findByCode(code);
    }
}
