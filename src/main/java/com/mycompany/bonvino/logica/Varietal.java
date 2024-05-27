package com.mycompany.bonvino.logica;

public class Varietal {
    int id;
    String descripcion;
    int porcentajeComposicion;

    public Varietal(int id, String descripcion, int porcentajeComposicion) {
        this.id = id;
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPorcentajeComposicion(int porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }
    
    
}
