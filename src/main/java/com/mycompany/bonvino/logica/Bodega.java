
package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bodega {
    float[] coordenadasUbicacion;
    String descripcion;
    String historia;
    String nombre;
    String periodoActualizacion;
    RegionVitivinicola region;

    public Bodega(@JsonProperty("coordenadasUbicación") float[] coordenadasUbicacion, 
            @JsonProperty("nombre") String nombre, 
            @JsonProperty("descripcion") String descripcion, 
            @JsonProperty("historia") String historia, 
            @JsonProperty("periodoActualizacion") String periodoActualizacion,
            @JsonProperty("region") RegionVitivinicola region) {
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
        this.region = region;
    }

    public String getNombre() {
       return nombre;
    }

    List<String> getRegionYPais() {
        List<String> infoRegionYPais = new ArrayList();
        String nombreRegion = this.region.getNombre();
        String nombrePais = this.region.getPais();
        infoRegionYPais.add(nombreRegion);
        infoRegionYPais.add(nombrePais);
        return infoRegionYPais;
    }
}
