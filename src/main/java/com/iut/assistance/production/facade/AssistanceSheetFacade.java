package com.iut.assistance.production.facade;

import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.GroupFormationDto;
import com.iut.assistance.production.models.dto.StudentAssistance;
import com.iut.assistance.production.models.dto.StudentAssistanceSheet;
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


    public AssistanceSheetDto createAssistanceSheet(GroupFormationDto sheetDto){
        AuthenticationUser user = (AuthenticationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Teacher teacher = teacherService.findByUser(userService.findByEmail(user.getUsername()));
        Module module = moduleService.findById(sheetDto.getModuleId());
        Group group = groupService.findById(sheetDto.getGroupId());

        AssistanceSheet assistanceSheet = new AssistanceSheet(new Date(), teacher, group, statusSheetService.findByCode("ACTIVE"), module);
        assistanceSheet =  assistanceSheetService.createAssistanceSheet(assistanceSheet);
        return mapper.assitanceSheetToDto(assistanceSheet);
    }

    public void registerStudentAssistance(StudentAssistanceSheet studentAssistanceSheet){
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(studentAssistanceSheet.getAssitanceSheetId());
        User user                       = userService.findByIdentifierNumber(studentAssistanceSheet.getStudentNumber());
        Student student                 = studentService.findByUser(user);

        StudentSheetAssistance sheetAssistance = new StudentSheetAssistance();
        sheetAssistance.setStudent(student);
        sheetAssistance.setDate(new Date());
        sheetAssistance.setAssistanceSheet(assistanceSheet);
        sheetAssistance.setStatusSheetStudent(statusSheetStudentService.findByCode("IN_TIME"));
        studentSheetAssistanceService.save(sheetAssistance);
    }

    public AssistanceSheetDto viewAssistanceSheet(Long id){
        AssistanceSheet assistanceSheet = assistanceSheetService.findById(id);
        List<StudentSheetAssistance> studentSheetAssistances =  assistanceSheet.getStudentSheetAssistances();
        AssistanceSheetDto dto = mapper.assitanceSheetToDto(assistanceSheet);

        List<StudentAssistance> studentAssistances = new ArrayList<>();

        for(StudentSheetAssistance sheet : studentSheetAssistances){
            studentAssistances.add(new StudentAssistance(sheet.getId(), sheet.getStudent().getUser().getName(),
                    sheet.getStudent().getUser().getLastName(), sheet.getStudent().getUser().getIdentifierNumber(), sheet.getDate()));
        }

        dto.setStudents(studentAssistances);
        return dto;
    }

    public void deleteStudentFromAssistanceSheet(Long id){
        studentSheetAssistanceService.deleteById(id);
    }
}
