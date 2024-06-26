

package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reseña {
    String comentario;
    Boolean esPremium;
    String fechaResena;
    int puntaje;

    public Reseña(@JsonProperty("comentario") String comentario, 
            @JsonProperty("esPremium") Boolean esPremium, 
            @JsonProperty("fechaReseña") String fechaResena, 
            @JsonProperty("puntaje") int puntaje
            ) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
    }

    public boolean esDelPeriodo(String fechaDesde, String fechaHasta) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate desde = LocalDate.parse(fechaDesde, formatter);
        LocalDate hasta = LocalDate.parse(fechaHasta, formatter);
        LocalDate resena = LocalDate.parse(fechaResena, formatter);
        
        return resena.isBefore(hasta) && resena.isAfter(desde);
    }

    public boolean esPremium() {
             return esPremium;
    }
    
    int getPuntaje(){
        return this.puntaje;
    }
}
