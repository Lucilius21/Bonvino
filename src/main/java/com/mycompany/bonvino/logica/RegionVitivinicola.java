
package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegionVitivinicola extends Provincia {
    String descripcion;
    String nombreRegion;

    public RegionVitivinicola(@JsonProperty("nombreRegion") String nombreRegion, 
            @JsonProperty("descripcion") String descripcion, 
            @JsonProperty("nombreProvincia") String nombreProvincia, 
            @JsonProperty("nombrePais") String nombrePais) {
        super(nombreProvincia, nombrePais);
        this.descripcion = descripcion;
        this.nombreRegion = nombreRegion;
    }

    public String getNombre() {
        return nombreRegion;
    }

    String getPais() {
        return super.getPais();
    }
}