package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Group;
import com.iut.assistance.production.models.repositories.GroupRepository;
import com.iut.assistance.production.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired private GroupRepository repository;

    @Transactional(readOnly = true)
    @Override
    public Group findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
