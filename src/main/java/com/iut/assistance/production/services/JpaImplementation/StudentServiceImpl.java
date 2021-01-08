package com.iut.assistance.production.services.JpaImplementation;

import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.models.repositories.StudentRepository;
import com.iut.assistance.production.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Transactional
    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Student findByUser(User user) {
        return repository.findByUser(user);
    }
}
