package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.Teacher;
import com.iut.assistance.production.models.entities.User;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher findByUser(User user);
}
