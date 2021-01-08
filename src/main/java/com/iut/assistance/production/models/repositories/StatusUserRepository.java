package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.StatusUser;
import org.springframework.data.repository.CrudRepository;

public interface StatusUserRepository extends CrudRepository<StatusUser, Long> {

    StatusUser findByCode(Integer code);
}