package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.models.entities.ValidationUser;
import com.iut.assistance.production.models.repositories.ValidationUserRepository;
import com.iut.assistance.production.services.ValidationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class ValidationUserServiceImpl implements ValidationUserService {

    @Autowired private ValidationUserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public ValidationUser searchByemailConfirmationToken(String token){
        return repository.findByEmailConfirmationToken(token);
    }

    @Transactional
    @Override
    public ValidationUser registerEmailConfirmation(User user, String token) {
        ValidationUser validation = new ValidationUser(token,new Timestamp(System.currentTimeMillis()), user);
        return repository.save(validation);
    }

}
