package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Long> {

    Group findByName(String name);

}
