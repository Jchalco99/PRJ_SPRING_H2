package com.tecsup.demo.services;

import com.tecsup.demo.domain.entities.Rifa;

import java.util.List;

public interface RifaService {
    public void grabar(Rifa sede);
    public void eliminar(int id);
    public Rifa buscar(Integer id);
    public List<Rifa> listar();
}
