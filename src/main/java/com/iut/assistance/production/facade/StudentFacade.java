package com.iut.assistance.production.facade;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.services.StudentService;
import com.iut.assistance.production.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentFacade {

    @Autowired private UserService userService;
    @Autowired private StudentService studentService;

    public Student createStudent(UserDto dto) {
        try {
            Boolean flag = userService.existsByEmailOrIdentifierNumber(dto.getEmail(), dto.getIdentifierNumber());
            if (!flag)
                return studentService.save(new Student(userService.register(dto, false)));
            else
                throw new ApiRequestException("Le courriel ou l'identifiant est deja enregistre.");

        } catch (NullPointerException exception) {
            exception.printStackTrace();
            throw new ApiRequestException(exception.getMessage());
        }
    }
}
