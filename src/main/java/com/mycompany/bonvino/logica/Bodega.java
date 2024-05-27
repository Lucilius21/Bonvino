
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
    int coordenadasUbicacion;
    String descripcion;
    String historia;
    String nombre;
    String periodoActualizacion;
    int idBodega;
    int idRegion;

    public Bodega(@JsonProperty("idRegion") int idRegion, 
            @JsonProperty("idBodega") int idBodega, 
            @JsonProperty("coordenadasUbicacion") int coordenadasUbicacion, 
            @JsonProperty("nombre") String nombre, 
            @JsonProperty("descripcion") String descripcion, 
            @JsonProperty("historia") String historia, 
            @JsonProperty("periodoActualizacion") String periodoActualizacion) {
        this.idBodega = idBodega;
        this.coordenadasUbicacion = coordenadasUbicacion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.nombre = nombre;
        this.periodoActualizacion = periodoActualizacion;
        this.idRegion = idRegion;
    }

    public int getIdBodega() {
        return idBodega;
    }

    public String getNombre() {
       return nombre;
    }

    public List<String> getRegionYPais() {
        List<String> regionInfo = new ArrayList<>(); 
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            RegionVitivinicola [ ] regionArray = objectMapper.readValue(new File("regiones.json"), RegionVitivinicola[ ].class);
            for (RegionVitivinicola region : regionArray){
                if (region.getIdRegion() == this.idRegion){
                    regionInfo.add(region.getNombre());
                    regionInfo.add(region.getPais());
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Vino.class.getName()).log(Level.SEVERE, null, ex);
        }
       return regionInfo;}}
