package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.Privilege;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    Privilege findByName(String name);
}
