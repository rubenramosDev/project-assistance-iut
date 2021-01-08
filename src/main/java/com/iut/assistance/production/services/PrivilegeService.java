package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.Privilege;

public interface PrivilegeService {

    Privilege searchByName(String name);
}
