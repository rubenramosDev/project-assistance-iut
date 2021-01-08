package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Module;
import com.iut.assistance.production.models.repositories.ModuleRepository;
import com.iut.assistance.production.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired private ModuleRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Module findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Module> findByModuleByFormation(String idFormation){
        return repository.findByModuleByFormation(idFormation) ;
    }
}
