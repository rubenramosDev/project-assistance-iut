package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.StatusSheetStudent;

public interface StatusSheetStudentService {

    StatusSheetStudent findByCode(String code);
}
