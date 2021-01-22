package com.iut.assistance.production.controllers;

import com.iut.assistance.production.facade.AssistanceSheetFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.StudentAssistanceSheet;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/api/assistance-sheet")
@CrossOrigin
public class AssistanceSheetStudentController {

    @Autowired private AssistanceSheetFacade facade;

    @ApiOperation(value = "Student takes assistance in Assistance Sheet",
            notes = "No role required",
            response = String.class)
    @PostMapping("/assistance")
    public ResponseEntity registerStudentAssistanceSheet(@Valid @RequestBody StudentAssistanceSheet studentAssistanceSheet){
        facade.registerStudentAssistance(studentAssistanceSheet);
        return ResponseEntity.ok("ok");
    }
}
