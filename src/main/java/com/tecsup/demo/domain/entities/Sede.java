package com.tecsup.demo.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "sedes")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSede")
    private int id;

    @Column(name = "nombre_sede")
    @NotEmpty(message = "El nombre de la sede no puede estar vacío")
    private String nombre;

    @Column(name = "ubicacion_mapa")
    private String ubicacionMapa;

    @Column(name = "direccion")
    private String direccion;

    public Sede() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "El nombre de la sede no puede estar vacío") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty(message = "El nombre de la sede no puede estar vacío") String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacionMapa() {
        return ubicacionMapa;
    }

    public void setUbicacionMapa(String ubicacionMapa) {
        this.ubicacionMapa = ubicacionMapa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Sede{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacionMapa='" + ubicacionMapa + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
