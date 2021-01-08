package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.ValidationUser;
import org.springframework.data.repository.CrudRepository;

public interface ValidationUserRepository extends CrudRepository<ValidationUser, Long> {

    ValidationUser findByEmailConfirmationToken(String token);
}
