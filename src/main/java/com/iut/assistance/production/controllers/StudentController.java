package com.iut.assistance.production.controllers;

import com.iut.assistance.production.commons.ApiGenericResponse;
import com.iut.assistance.production.facade.StudentFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.AssistanceSheetDtoStudent;
import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.dto.UserUpdateDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/auth/api/student")
@CrossOrigin
public class StudentController {

    @Autowired private StudentFacade facade;

    @ApiOperation(value = "See my info as student",
            notes = "Student role required, Application role required ('ROL_STUDENT')",
            response = UserUpdateDto.class)
    @PreAuthorize("hasAuthority('ROL_STUDENT')")
    @GetMapping("/see/{identifierNumber}")
    public ResponseEntity<UserUpdateDto> seeMyInfo(@PathVariable String identifierNumber){
        return ResponseEntity.ok(facade.seeMyInfo(identifierNumber));
    }

    @ApiOperation(value = "Shows my asssitances sheets as a student",
            notes = "Application role required ('ROL_STUDENT')",
            response = AssistanceSheetDtoStudent.class)
    @PreAuthorize("hasAuthority('ROL_STUDENT')")
    @GetMapping("/view-my-assistances/{identifierNumber}")
    public ResponseEntity<List<AssistanceSheetDtoStudent>> viewAssistanceSheetByStudent(@PathVariable String identifierNumber){
        return ResponseEntity.ok(facade.viewAssistanceSheetByStudent(identifierNumber));
    }

    @ApiOperation(value = "Update my info as Student",
            notes = "Application role required ('ROL_STUDENT') Email is not updatable !",
            response = UserUpdateDto.class)
    @PreAuthorize("hasAuthority('ROL_STUDENT')")
    @PutMapping("/update")
    public ResponseEntity<UserUpdateDto> updateMyInfo(@Valid @RequestBody UserUpdateDto userUpdateDto){
        return ResponseEntity.ok(facade.updateMyInfo(userUpdateDto));
    }

    @ApiOperation(value = "Create a new student",
            response = ApiGenericResponse.class)
    @PostMapping("/register")
    public ResponseEntity<ApiGenericResponse> crateStudent(@Valid @RequestBody UserDto userDto) {
        facade.createStudent(userDto);
        return ResponseEntity.ok(new ApiGenericResponse("Veuillez activer", HttpStatus.OK, ZonedDateTime.now()));
    }



}
