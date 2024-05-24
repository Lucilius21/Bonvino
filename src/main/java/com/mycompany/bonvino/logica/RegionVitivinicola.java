
package com.mycompany.bonvino.logica;

public class RegionVitivinicola extends Provincia {
    String descripcion;
    String nombre;

    public RegionVitivinicola(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
}
