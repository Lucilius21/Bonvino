package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Varietal {
    String descripcion;
    int porcentajeComposicion;

    public Varietal(@JsonProperty("descripción") String descripcion, 
            @JsonProperty("porcentajeComposicion") int porcentajeComposicion) {
        this.descripcion = descripcion;
        this.porcentajeComposicion = porcentajeComposicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPorcentajeComposicion() {
        return porcentajeComposicion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPorcentajeComposicion(int porcentajeComposicion) {
        this.porcentajeComposicion = porcentajeComposicion;
    }
    
    
}
