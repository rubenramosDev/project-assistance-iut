package com.iut.assistance.production.facade;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.AssistanceSheetDtoStudent;
import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.dto.UserUpdateDto;
import com.iut.assistance.production.models.entities.Student;
import com.iut.assistance.production.models.entities.StudentSheetAssistance;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.services.StudentService;
import com.iut.assistance.production.services.StudentSheetAssistanceService;
import com.iut.assistance.production.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFacade {

    @Autowired private UserService userService;
    @Autowired private StudentService studentService;
    @Autowired private StudentSheetAssistanceService studentSheetAssistanceService;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserUpdateDto seeMyInfo(String identifierNumber){
        Student student = userService.findByIdentifierNumber(identifierNumber).getStudent();
        return new UserUpdateDto(student.getUser().getIdentifierNumber(), student.getUser().getEmail(),
                student.getUser().getName(), student.getUser().getLastName(),"");
    }

    public List<AssistanceSheetDtoStudent> viewAssistanceSheetByStudent(String identifierNumber){
        Student student = userService.findByIdentifierNumber(identifierNumber).getStudent();
        List<StudentSheetAssistance> studentSheetAssistances = studentSheetAssistanceService.findByStudent(student);
        return studentSheetAssistances.stream().map(sheet -> new AssistanceSheetDtoStudent(
                sheet.getAssistanceSheet().getId(),
                sheet.getAssistanceSheet().getStatusSheet().getCode(),
                sheet.getAssistanceSheet().getTeacher().getUser().getName(),
                sheet.getAssistanceSheet().getStartDate(),
                sheet.getAssistanceSheet().getGroup().getSemestre().getId(),
                sheet.getAssistanceSheet().getGroup().getSemestre().getSemestre(),
                sheet.getAssistanceSheet().getGroup().getId(),
                sheet.getAssistanceSheet().getGroup().getName(),
                sheet.getAssistanceSheet().getModule().getId(),
                sheet.getAssistanceSheet().getModule().getTitre(),
                sheet.getDate(),
                sheet.getStatusSheetStudent().getCode())).collect(Collectors.toList());
    }

    public String updateMyInfo(UserUpdateDto userUpdateDto){
        User user = userService.findByIdentifierNumber(userUpdateDto.getIdentifierNumber());
        user.setPassword(bCryptPasswordEncoder.encode(userUpdateDto.getPassword()));
        userService.save(user);
        return "ok";
    }

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
