package com.iut.assistance.production.controllers;

import com.iut.assistance.production.facade.FormationFacade;
import com.iut.assistance.production.models.dto.AssistanceSheetDto;
import com.iut.assistance.production.models.dto.FormationsDto;
import com.iut.assistance.production.services.ModuleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/auth/formation")
@CrossOrigin
public class FormationController {

    @Autowired private FormationFacade facade;

    @ApiOperation(value = "Get all formations",
            notes = "Application role required ('ROL_TEACHER')",
            response = FormationsDto.class)
    @PreAuthorize("hasAuthority('ROL_TEACHER')")
    @GetMapping("/get-all")
    public ResponseEntity getAllFormations(){
        return ResponseEntity.ok(facade.getAll());
    }
}
