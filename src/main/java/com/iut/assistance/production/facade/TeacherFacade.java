package com.iut.assistance.production.facade;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.dto.UserUpdateDto;
import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.Teacher;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.services.TeacherService;
import com.iut.assistance.production.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherFacade {

    @Autowired private TeacherService teacherService;
    @Autowired private UserService userService;

    public UserUpdateDto seeMyInfo(String identifierNumber){
        User user = userService.findByIdentifierNumber(identifierNumber);
        return new UserUpdateDto(user.getIdentifierNumber(), user.getEmail(),
                user.getName(), user.getLastName());
    }

    public UserUpdateDto updateMyInfo(UserUpdateDto userUpdateDto){
        User user = userService.findByIdentifierNumber(userUpdateDto.getIdentifierNumber());
        user.setName(userUpdateDto.getName());
        user.setLastName(userUpdateDto.getLastName());
        User userUpdated = userService.save(user);
        return new UserUpdateDto(userUpdated.getIdentifierNumber(), userUpdated.getEmail(),
                userUpdated.getName(), userUpdated.getLastName());
    }

    public Teacher createTeacher(UserDto dto) {
        try {

            if (!userService.existsByEmailOrIdentifierNumber(dto.getEmail(), dto.getIdentifierNumber()))
                return teacherService.save(new Teacher(userService.register(dto, true)));
            else
                throw new ApiRequestException("Le courriel ou l'identifiant est deja enregistre.");

        } catch (NullPointerException exception) {
            exception.printStackTrace();
            throw new ApiRequestException(exception.getMessage());
        }
    }

}
