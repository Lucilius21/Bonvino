
package com.mycompany.bonvino.logica;

public class Reseña {
    String comentario;
    Boolean esPremium;
    int fechaResena;
    int puntaje;

    public Reseña(String comentario, Boolean esPremium, int fechaResena, int puntaje) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
    }
}