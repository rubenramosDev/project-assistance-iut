package com.iut.assistance.production.facade;

import com.iut.assistance.production.commons.exceptions.ApiRequestException;
import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.models.entities.ValidationUser;
import com.iut.assistance.production.services.StatusUserService;
import com.iut.assistance.production.services.UserService;
import com.iut.assistance.production.services.ValidationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUserFacade {

    @Autowired private ValidationUserService validationService;
    @Autowired private UserService userService;
    @Autowired private StatusUserService statusUserService;

    public void validateToken(String token) {
        try {
            ValidationUser validation = validationService.searchByemailConfirmationToken(token);
            if (validation != null) {
                User user = userService.findById(validation.getUser().getId());
                user.setStatusUser(statusUserService.findByCode(1));
                userService.save(user);
            } else {
                throw new ApiRequestException("Invalid token");
            }
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            throw new ApiRequestException(exception.getMessage());
        }
    }

}
