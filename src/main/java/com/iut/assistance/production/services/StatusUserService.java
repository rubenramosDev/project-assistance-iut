package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.StatusUser;

public interface StatusUserService {

    StatusUser findByCode(Integer code);

}
