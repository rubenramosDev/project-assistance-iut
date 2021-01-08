package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>{

    Student findByUser(User user);

}