package com.iut.assistance.production.services;

import com.iut.assistance.production.models.entities.Module;

import java.util.List;

public interface ModuleService {

    Module findById(Long id);

    List<Module> findByModuleByFormation(String idFormation);
}
