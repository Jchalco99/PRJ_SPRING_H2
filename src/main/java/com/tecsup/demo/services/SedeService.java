package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Sede;

import java.util.List;

public interface SedeService {
    public void grabar(Sede sede);
    public void eliminar(int id);
    public Sede buscar(Integer id);
    public List<Sede> listar();
}
