
package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegionVitivinicola extends Provincia {
    String descripcion;
    String nombre;
    int idRegion;

    public RegionVitivinicola(@JsonProperty("idRegion") int idRegion, 
            @JsonProperty("nombre") String nombre, 
            @JsonProperty("descripcion") String descripcion, 
            @JsonProperty("nombreProvincia") String nombreProvincia, 
            @JsonProperty("nombrePais") String nombrePais) {
        super(nombreProvincia, nombrePais);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.idRegion = idRegion;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        String nombrePais;
        nombrePais = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Provincia [ ] provinciaArray = objectMapper.readValue(new File("provincias.json"), Provincia[ ].class);
            for (Provincia provincia : provinciaArray){
                if (provincia.getNombre().equals(this.nombreProvincia)){
                    nombrePais = provincia.getPais(this.nombreProvincia);
                }
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Vino.class.getName()).log(Level.SEVERE, null, ex);
    }
    return nombrePais;
}}
