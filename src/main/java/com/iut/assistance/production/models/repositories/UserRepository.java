package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByEmail(String email);

    Boolean existsByEmailOrIdentifierNumber(String email, String identifier);

    User findByIdentifierNumber(String identifier);

}