package com.iut.assistance.production.facade;

import com.iut.assistance.production.models.dto.*;
import com.iut.assistance.production.models.dto.mapper.AssistanceSheetMapper;
import com.iut.assistance.production.models.entities.Module;
import com.iut.assistance.production.models.entities.*;
import com.iut.assistance.production.security.models.AuthenticationUser;
import com.iut.assistance.production.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssistanceSheetFacade {

    @Autowired private AssistanceSheetService assistanceSheetService;
    @Autowired private TeacherService teacherService;
    @Autowired private StudentService studentService;
    @Autowired private UserService userService;
    @Autowired private StatusSheetService statusSheetService;
    @Autowired private StudentSheetAssistanceService studentSheetAssistanceService;
    @Autowired private StatusSheetStudentService statusSheetStudentService;
    @Autowired private ModuleService moduleService;
    @Autowired private GroupService groupService;
    @Autowired private AssistanceSheetMapper mapper;

    public AssistanceSheetDto viewAssistanceSheet(Long id) {
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(id);
        List<StudentSheetAssistance> studentSheetAssistance = assistanceSheet.getStudentSheetAssistances();
        AssistanceSheetDto dto = mapper.assitanceSheetToDto(assistanceSheet);

        List<StudentAssistance> studentAssistance = studentSheetAssistance.stream().map(student ->
                new StudentAssistance(student.getId(), student.getStudent().getUser().getName(),
                        student.getStudent().getUser().getLastName(), student.getStudent().getUser().getIdentifierNumber(),
                        student.getDate(), student.getStatusSheetStudent().getCode())).collect(Collectors.toList());

        dto.setStudents(studentAssistance);
        return dto;
    }


    public List<AssistanceSheetDto> viewAssistanceSheetByTeacher(String identifierNumber) {
        return mapper.assitanceSheetToDto(assistanceSheetService.findByTeacher(teacherService.findByUser(userService.findByIdentifierNumber(identifierNumber))));

    }

    public AssistanceSheetDto createAssistanceSheet(GroupFormationDto sheetDto) {
        AuthenticationUser user = (AuthenticationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherService.findByUser(userService.findByEmail(user.getUsername()));

        Module module = moduleService.findById(sheetDto.getModuleId());
        Group group   = groupService.findById(sheetDto.getGroupId());

        AssistanceSheet assistanceSheet = new AssistanceSheet(new Date(), teacher, group, statusSheetService.findByCode("ACTIVE"), module);
        return mapper.assitanceSheetToDto(assistanceSheetService.saveAssistanceSheet(assistanceSheet));
    }

    public AssistanceSheetDto updateModuleAndGroup(AssistanceSheetDto assistanceSheetDto) {
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(assistanceSheetDto.getAssistanceSheetId());
        assistanceSheet.setModule(moduleService.findById(assistanceSheetDto.getIdModule()));
        assistanceSheet.setGroup(groupService.findById(assistanceSheetDto.getIdGroup()));

        return mapper.assitanceSheetToDto(assistanceSheetService.saveAssistanceSheet(assistanceSheet));
    }

    public AssistanceSheetDto updateStudentStatus(StudentAssistanceSheetDto assistanceSheetDto) {
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(assistanceSheetDto.getAssistanceSheetId());
        Student student = studentService.findByUser(userService.findByIdentifierNumber(assistanceSheetDto.getIdentifierNumber()));

        for (StudentSheetAssistance assistance : assistanceSheet.getStudentSheetAssistances()) {
            if (assistance.getStudent().getUser().getIdentifierNumber() == student.getUser().getIdentifierNumber()) {
                assistance.setStatusSheetStudent(statusSheetStudentService.findByCode(assistanceSheetDto.getStatus()));
            }
        }

        return mapper.assitanceSheetToDto(assistanceSheetService.saveAssistanceSheet(assistanceSheet));
    }

    public AssistanceSheetDto updateAddStudent(Long idSheet, String identifierNumber) {
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(idSheet);

        // New student
        StudentSheetAssistance assistance = new StudentSheetAssistance();
        assistance.setDate(new Date());
        assistance.setStudent(studentService.findByUser(userService.findByIdentifierNumber(identifierNumber)));
        assistance.setStatusSheetStudent(statusSheetStudentService.findByCode("JUSTIFIED"));
        assistance.setAssistanceSheet(assistanceSheet);
        studentSheetAssistanceService.save(assistance);

        return mapper.assitanceSheetToDto(assistanceSheet);
    }


//    TODO return an studentDto
    public void registerStudentAssistance(StudentAssistanceSheet studentAssistanceSheet) {
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(studentAssistanceSheet.getAssitanceSheetId());
        User user = userService.findByIdentifierNumber(studentAssistanceSheet.getStudentNumber());
        Student student = studentService.findByUser(user);

        StudentSheetAssistance sheetAssistance = new StudentSheetAssistance();
        sheetAssistance.setStudent(student);
        sheetAssistance.setDate(new Date());
        sheetAssistance.setAssistanceSheet(assistanceSheet);
        sheetAssistance.setStatusSheetStudent(statusSheetStudentService.findByCode("IN_TIME"));
        studentSheetAssistanceService.save(sheetAssistance);
    }

    public void deleteStudentFromAssistanceSheet(Long idSheet, String identifierNumber) {
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(idSheet);
        List<StudentSheetAssistance> studentSheetAssistances = studentSheetAssistanceService.findByAssistanceSheet(assistanceSheet);

        for(StudentSheetAssistance assistance : studentSheetAssistances){
            if (assistance.getStudent().getUser().getIdentifierNumber().equals(identifierNumber)) {
                studentSheetAssistanceService.deleteById(assistance.getId());
            }
        }
    }
}
