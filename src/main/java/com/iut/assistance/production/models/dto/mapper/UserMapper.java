package com.iut.assistance.production.models.dto.mapper;

import com.iut.assistance.production.models.dto.UserDto;
import com.iut.assistance.production.models.entities.StatusUser;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.services.StatusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired private StatusUserService service;

    public User dtoToUser(UserDto dto) {
        StatusUser statusUser = service.findByCode(2);
        User user = new User(
                dto.getEmail(),
                dto.getIdentifierNumber(),
                dto.getName(),
                dto.getLastName(),
                statusUser
        );
        return user;
    }
}
