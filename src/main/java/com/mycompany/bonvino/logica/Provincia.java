
package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Provincia extends Pais {
    String nombreProvincia;

    public Provincia(@JsonProperty("nombreProvincia") String nombreProvincia, 
            @JsonProperty("nombrePais") String nombrePais) {
        super(nombrePais);
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombre() {
       return nombreProvincia;
    }

    String getPais() {
        return super.getNombre();
    }
}