package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Rifa;
import com.tecsup.demo.domain.persistance.RifaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RifaServiceImpl implements RifaService{
    @Autowired
    private RifaDao dao;

    @Override
    @Transactional
    public void grabar(Rifa rifa) {
        dao.save(rifa);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Rifa buscar(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rifa> listar() {
        return (List<Rifa>) dao.findAll();
    }
}
