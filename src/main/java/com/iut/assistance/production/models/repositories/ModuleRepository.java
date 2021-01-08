package com.iut.assistance.production.models.repositories;

import com.iut.assistance.production.models.entities.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Long> {

    Module findByTitre(String titre);

    @Query(value = "SELECT * FROM modules INNER JOIN matiers m on modules.matiere_id = m.id INNER JOIN unites_enseignements ue on m.unite_enseignement_id = ue.id INNER JOIN formations f on ue.formation_id = f.id WHERE f.id LIKE ?1",
    nativeQuery = true)
    List<Module> findByModuleByFormation(String idFormation);

}
