package com.tecsup.demo.domain.persistance;

import com.tecsup.demo.domain.entities.Rifa;
import org.springframework.data.repository.CrudRepository;

public interface RifaDao extends CrudRepository<Rifa, Integer> {
}
