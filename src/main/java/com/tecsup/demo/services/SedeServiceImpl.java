package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Sede;
import com.tecsup.demo.domain.persistance.SedeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SedeServiceImpl implements SedeService{
    @Autowired
    private SedeDao dao;

    @Override
    @Transactional
    public void grabar(Sede sede) {
        dao.save(sede);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Sede buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sede> listar() {
        return (List<Sede>) dao.findAll();
    }
}
