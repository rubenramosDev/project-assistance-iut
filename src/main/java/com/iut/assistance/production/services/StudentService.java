package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.User;

public interface StudentService {

    Student save(Student student);

    Student findByUser(User user);
}
