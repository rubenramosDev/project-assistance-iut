package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Teacher;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.models.repositories.TeacherRepository;
import com.iut.assistance.production.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired private TeacherRepository repository;

    @Transactional
    @Override
    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    @Transactional(readOnly = true)
    @Override
    public Teacher findByUser(User user) {
        return repository.findByUser(user);
    }

}
