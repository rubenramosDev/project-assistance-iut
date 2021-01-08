package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.StatusUser;
import com.iut.assistance.production.models.repositories.StatusUserRepository;
import com.iut.assistance.production.services.StatusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatusUserServiceImpl implements StatusUserService {

    @Autowired
    private StatusUserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public StatusUser findByCode(Integer code) {
        return repository.findByCode(code);
    }

}
