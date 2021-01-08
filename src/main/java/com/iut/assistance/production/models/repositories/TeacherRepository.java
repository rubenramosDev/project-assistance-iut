package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.Teacher;
import com.iut.assistance.production.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long>{

    Teacher findByUser(User user);

}