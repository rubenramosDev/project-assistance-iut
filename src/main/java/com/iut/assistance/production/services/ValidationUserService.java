package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.User;
import com.iut.assistance.production.models.entities.ValidationUser;

public interface ValidationUserService {

    ValidationUser searchByemailConfirmationToken(String token);

    ValidationUser registerEmailConfirmation(User user,String token);

}
