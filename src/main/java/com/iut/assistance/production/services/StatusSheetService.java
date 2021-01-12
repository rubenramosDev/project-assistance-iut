package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.StatusSheet;

public interface StatusSheetService {

    StatusSheet findByCode(String code);
}

