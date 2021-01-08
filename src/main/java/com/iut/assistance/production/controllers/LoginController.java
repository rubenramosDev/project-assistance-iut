package com.iut.assistance.production.controllers;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.dto.FormationsDto;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.security.dto.JwtDto;
import com.iut.assistance.production.security.dto.Login;
import com.iut.assistance.production.security.jwt.JwtProvider;
import com.iut.assistance.production.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class LoginController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtProvider jwtProvider;
    @Autowired private UserService userService;

    @ApiOperation(value = "Login",
            notes = "No role required",
            response = JwtDto.class)
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login (@Valid @RequestBody Login user){
        User u = userService.findByEmail(user.getEmail());
        if(u == null){
            throw new ApiRequestException("Le courriel ne pas enregistré.");
        }
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt, u.getName(), u.getLastName());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
