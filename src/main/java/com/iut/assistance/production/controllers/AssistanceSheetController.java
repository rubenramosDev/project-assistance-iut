package com.iut.assistance.production.controllers;

import com.iut.assistance.production.facade.AssistanceSheetFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.GroupFormationDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/assistance-sheet")
@CrossOrigin
public class AssistanceSheetController {

    @Autowired private AssistanceSheetFacade facade;

    @ApiOperation(value = "Verify how many students are register",
            notes = "Application role required ('ROL_TEACHER')",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @GetMapping("/view/{id}")
    public ResponseEntity<AssistanceSheetDto> viewAssistanceSheet(@PathVariable Long id) {
        return ResponseEntity.ok(facade.viewAssistanceSheet(id));
    }

    @ApiOperation(value = "Create a new assistance sheet",
            notes = "Application role required ('ROL_TEACHER')",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PostMapping("/create")
    public ResponseEntity<AssistanceSheetDto> createAssistanceSheet(@Valid @RequestBody GroupFormationDto assistanceDto) {
        return ResponseEntity.ok(facade.createAssistanceSheet(assistanceDto));
    }

    @ApiOperation(value = "Delete student from assistance sheet",
            notes = "Application role required ('ROL_TEACHER')")
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @DeleteMapping("/delete/{id}/{identifierNumber}")
    public ResponseEntity deleteStudentFromAssistanceSheet(@PathVariable Long id) {
        facade.deleteStudentFromAssistanceSheet(id);
        return ResponseEntity.ok("");
    }
}
