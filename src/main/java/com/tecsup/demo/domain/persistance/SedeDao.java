package com.tecsup.demo.domain.persistance;

import com.tecsup.demo.domain.entities.Sede;
import org.springframework.data.repository.CrudRepository;

public interface SedeDao extends CrudRepository<Sede, Integer> {
}
