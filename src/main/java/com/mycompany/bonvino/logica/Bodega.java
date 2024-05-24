
package com.mycompany.bonvino.logica;

public class Bodega {
    int coordenadasUbicacion;
    String descripcion;
    String historia;
    String nombre;
    int periodoActualizar;

    public Bodega(int coordenadasUbicacion, String nombre, String descripcion, String historia, int periodoActualizar) {
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.nombre = nombre;
        this.periodoActualizar = periodoActualizar;
    }
    
}
