package com.tecsup.demo.domain.persistance;

import com.tecsup.demo.domain.entities.Auditoria;
import org.springframework.data.repository.CrudRepository;

public interface AuditoriaDao extends CrudRepository<Auditoria, Integer> {
}
