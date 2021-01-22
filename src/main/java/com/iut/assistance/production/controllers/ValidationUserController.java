package com.iut.assistance.production.controllers;

import com.iut.assistance.production.commons.ApiGenericResponse;
import com.iut.assistance.production.facade.ValidationUserFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/auth/api/validaton")
@CrossOrigin
public class ValidationUserController {

    @Autowired private ValidationUserFacade facade;

    @ApiOperation(value = "Active a recent created account",
            notes = "No application role required",
            response = ApiGenericResponse.class)
    @GetMapping("/active/{token}")
    public ResponseEntity<ApiGenericResponse> validateToken(@PathVariable String token){
        facade.validateToken(token);
        return ResponseEntity.ok(new ApiGenericResponse("Activated", HttpStatus.OK, ZonedDateTime.now()));
    }

}
