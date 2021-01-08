package com.iut.assistance.production.services;

import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.entities.User;

public interface UserService {

    User findById(Long id);

    User save(User user);

    Boolean existsByEmailOrIdentifierNumber(String email, String identifier);

    User register(UserDto dto, Boolean isTeacher);

    User findByEmail(String email);

    User findByIdentifierNumber(String identifierNumber);

}
