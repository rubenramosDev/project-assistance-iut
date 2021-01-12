package com.iut.assistance.production.controllers;

import com.iut.assistance.production.commons.ApiGenericResponse;
import com.iut.assistance.production.facade.StudentFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.UserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/auth/api/student")
@CrossOrigin
public class StudentController {

    @Autowired private StudentFacade service;

    @ApiOperation(value = "Create a new student",
            notes = "No application role required",
            response = String.class)
    @PostMapping("/register")
    public ResponseEntity<ApiGenericResponse> crateStudent(@Valid @RequestBody UserDto userDto) {
        service.createStudent(userDto);
        return ResponseEntity.ok(new ApiGenericResponse("Veuillez activer", HttpStatus.OK, ZonedDateTime.now()));
    }
}
