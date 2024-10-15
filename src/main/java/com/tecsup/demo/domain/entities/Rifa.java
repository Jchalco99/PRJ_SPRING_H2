package com.tecsup.demo.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "rifas")
public class Rifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrifas")
    private int id;

    @Column(name = "nombre_rifa")
    @NotEmpty(message = "El nombre de la rifa no puede estar vacío")
    private String nombre;

    @Column(name = "fecha_rifa")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaRifa;

    @Column(name = "precio_boleto")
    @PositiveOrZero(message = "El precio del boleto debe ser cero o positivo")
    private double precioBoleto;

    @Column(name = "cantidad_boleto")
    @PositiveOrZero(message = "La cantidad de boletos debe ser cero o positiva")
    private int cantidadBoleto;

    @ManyToOne
    @JoinColumn(name = "sedes_id_Sede", nullable = false)
    private Sede sede;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty(message = "El nombre de la rifa no puede estar vacío") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty(message = "El nombre de la rifa no puede estar vacío") String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaRifa() {
        return fechaRifa;
    }

    public void setFechaRifa(Date fechaRifa) {
        this.fechaRifa = fechaRifa;
    }

    @PositiveOrZero(message = "El precio del boleto debe ser cero o positivo")
    public double getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(@PositiveOrZero(message = "El precio del boleto debe ser cero o positivo") double precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    @PositiveOrZero(message = "La cantidad de boletos debe ser cero o positiva")
    public int getCantidadBoleto() {
        return cantidadBoleto;
    }

    public void setCantidadBoleto(@PositiveOrZero(message = "La cantidad de boletos debe ser cero o positiva") int cantidadBoleto) {
        this.cantidadBoleto = cantidadBoleto;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Rifa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaRifa=" + fechaRifa +
                ", precioBoleto=" + precioBoleto +
                ", cantidadBoleto=" + cantidadBoleto +
                ", sede=" + sede +
                '}';
    }
}
