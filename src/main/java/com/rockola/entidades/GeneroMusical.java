package com.rockola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tgenerosmusicales")
public class GeneroMusical {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre", length=45, nullable=false, unique=true)
    private String nombre;
    
    @Column(name="carpeta", length=45, nullable=false, unique=true)
    private String carpeta;
    
    @Column(name="hab", columnDefinition = "TINYINT", nullable=false)
    private boolean hab;

    public GeneroMusical() {
    }

    public GeneroMusical(String nombre, String carpeta, boolean hab) {
        this.nombre = nombre;
        this.carpeta = carpeta;
        this.hab = hab;
    }

    public GeneroMusical(int id, String nombre, String carpeta, boolean hab) {
        this.id = id;
        this.nombre = nombre;
        this.carpeta = carpeta;
        this.hab = hab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }
    
    
}
