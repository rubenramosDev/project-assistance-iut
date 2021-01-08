package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Privilege;
import com.iut.assistance.production.models.repositories.PrivilegeRepository;
import com.iut.assistance.production.services.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired private PrivilegeRepository repository;

    @Override
    public Privilege searchByName(String name) {
        return repository.findByName(name);
    }
}
