
package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {
    String nombrePais;

    public Pais(@JsonProperty("nombrePais") String nombrePais) {
        this.nombrePais = nombrePais;
    }

    String getNombre() {
        return this.nombrePais;
    }
}
