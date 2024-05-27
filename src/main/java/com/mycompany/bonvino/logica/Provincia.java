
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

    public String getPais(String nom) {
        String nomPais;
        nomPais = "";
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            Pais [ ] paisArray = objectMapper.readValue(new File("paises.json"), Pais[ ].class);
            for (Pais pais : paisArray){
                if (this.nombrePais.equals(pais.getNombre())) {
                   nomPais = pais.getNombre();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Vino.class.getName()).log(Level.SEVERE, null, ex);
    }
        return nomPais;
    }}
