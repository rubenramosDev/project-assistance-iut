package com.iut.assistance.production.controllers;

import com.iut.assistance.production.facade.AssistanceSheetFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.GroupFormationDto;
import com.iut.assistance.production.models.dto.StudentAssistanceSheetDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/assistance-sheet")
@CrossOrigin
public class AssistanceSheetController {

    @Autowired private AssistanceSheetFacade facade;

    @ApiOperation(value = "Shows details from an assistance sheet in particular",
            notes = "Application role required ('ROL_TEACHER')" +
                    "Requires id from assistance sheet",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @GetMapping("/view/{idSheet}")
    public ResponseEntity<AssistanceSheetDto> viewAssistanceSheet(@PathVariable Long idSheet) {
        return ResponseEntity.ok(facade.viewAssistanceSheet(idSheet));
    }

    @ApiOperation(value = "Shows all assistances sheets created by teacher",
            notes = "Application role required ('ROL_TEACHER')" +
                    "Require identifier number from teacher",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @GetMapping("/view-by-teacher/{identifierNumber}")
    public ResponseEntity<List<AssistanceSheetDto>> viewAssistanceSheetByTeacher(@PathVariable String identifierNumber){
        return ResponseEntity.ok(facade.viewAssistanceSheetByTeacher(identifierNumber));
    }

    @ApiOperation(value = "Create a new assistance sheet",
            notes = "Application role required ('ROL_TEACHER')",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PostMapping("/create")
    public ResponseEntity<AssistanceSheetDto> createAssistanceSheet(@Valid @RequestBody GroupFormationDto assistanceDto) {
        return ResponseEntity.ok(facade.createAssistanceSheet(assistanceDto));
    }

    @ApiOperation(value = "Update module and group from assistance sheet existant",
            notes = "Application role required ('ROL_TEACHER')",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PutMapping("/update/module-group")
    public ResponseEntity<AssistanceSheetDto> updateModuleAndGroupAssistanceSheet(@RequestBody AssistanceSheetDto assistanceDto) {
        return ResponseEntity.ok(facade.updateModuleAndGroup(assistanceDto));
    }

    @ApiOperation(value = "Update status from a student already register",
            notes = "Application role required ('ROL_TEACHER')",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PutMapping("/update/student-status")
    public ResponseEntity<AssistanceSheetDto> updateStudentStatus(@RequestBody StudentAssistanceSheetDto assistanceSheetDto) {
        return ResponseEntity.ok(facade.updateStudentStatus(assistanceSheetDto));
    }

    @ApiOperation(value = "Add student to an assistance sheet",
            notes = "Application role required ('ROL_TEACHER')" +
                    "First param correspond to Sheet ID, second param correspond to IdentifierNumber (unique)",
            response = AssistanceSheetDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @PutMapping("/update/add-student/{idSheet}/{identifierNumber}")
    public ResponseEntity<AssistanceSheetDto> updateAddStudent(@PathVariable Long idSheet, @PathVariable String identifierNumber) {
        return ResponseEntity.ok(facade.updateAddStudent(idSheet, identifierNumber));
    }


    @ApiOperation(value = "Delete student from assistance sheet",
            notes = "Application role required ('ROL_TEACHER')" +
                    "First param correspond to Sheet ID, second param correspond to IdentifierNumber (unique)")
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @DeleteMapping("/delete/{idSheet}/{identifierNumber}")
    public ResponseEntity deleteStudentFromAssistanceSheet(@PathVariable Long idSheet, @PathVariable String identifierNumber) {
        facade.deleteStudentFromAssistanceSheet(idSheet, identifierNumber);
        return ResponseEntity.ok("");
    }
}
