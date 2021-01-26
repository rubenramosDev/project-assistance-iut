package com.iut.assistance.production.controllers;

import com.iut.assistance.production.commons.ApiGenericResponse;
import com.iut.assistance.production.facade.TeacherFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
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

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired private TeacherFacade facade;

    @ApiOperation(value = "See my info as teacher",
            notes = "Teacher role required",
            response = UserUpdateDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @GetMapping("/see/{identifierNumber}")
    public ResponseEntity<UserUpdateDto> seeMyInfo(@PathVariable String identifierNumber){
        return ResponseEntity.ok(facade.seeMyInfo(identifierNumber));
    }

    @ApiOperation(value = "Update my info as a teacher",
            notes = "No application role required, Email is not updatable !",
            response = UserUpdateDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PutMapping("/update")
    public ResponseEntity updateMyInfo(@Valid @RequestBody UserUpdateDto userUpdateDto){
        return ResponseEntity.ok(facade.updateMyInfo(userUpdateDto));
    }

    @ApiOperation(value = "Create a new teacher",
            notes = "Application role required ('ROL_TEACHER')",
            response = ApiGenericResponse.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PostMapping("/register")
    public ResponseEntity<ApiGenericResponse> createTeacher(@Valid @RequestBody UserDto userDto) {
        facade.createTeacher(userDto);
        return ResponseEntity.ok(new ApiGenericResponse("Veuillez activer", HttpStatus.OK, ZonedDateTime.now()));
    }
}
