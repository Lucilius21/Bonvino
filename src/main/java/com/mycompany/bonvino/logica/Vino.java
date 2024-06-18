
package com.mycompany.bonvino.logica;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vino {
    int anada;
    String imagenEtiqueta;
    String nombre;
    String notaDeCataBodega;
    int precioARS;
    List<Reseña> resena;
    List<Varietal> varietal;
    Bodega bodega;

    public Vino(
            @JsonProperty("añada") int anada,
            @JsonProperty("imagenEtiqueta") String imagenEtiqueta,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("notaDeCataBodega") String notaDeCataBodega,
            @JsonProperty("precio") int precioARS,
            @JsonProperty("reseña") List<Reseña> resena,
            @JsonProperty("varietal") List<Varietal> varietal,
            @JsonProperty("bodega") Bodega bodega
            ){
        this.anada = anada;
        this.imagenEtiqueta = imagenEtiqueta;
        this.nombre = nombre;
        this.notaDeCataBodega = notaDeCataBodega;
        this.precioARS = precioARS;
        this.resena = resena;
        this.varietal = varietal;
        this.bodega = bodega;
    }

    public String getNombre() {
        return this.nombre;
    }

    boolean tomarResenaSommelierEnPeriodo(String fechaDesde, String fechaHasta) {
        List<Reseña> resenaArray = this.resena;
        for (Reseña resena : resenaArray) {
            return resena.esDelPeriodo(fechaDesde, fechaHasta) && resena.esPremium();
                }
        return false;
    }

    public int getPrecio() {
        return this.precioARS;
    }
    
    public int getAnada() {
        return this.anada;
    }
    
    public String getImagen() {
        return this.imagenEtiqueta;
    }
    
    public String getNota() {
        return this.notaDeCataBodega;
    }

    List<String> buscarInformacionBodega() {
        List<String> infoBodega = new ArrayList();
        String nombreBodega = this.bodega.getNombre();
        List<String> infoUbicacion = this.bodega.getRegionYPais();
        infoBodega.add(nombreBodega);
        for (String e : infoUbicacion){
            infoBodega.add(e);}
        return infoBodega;
    }

    List<String> buscarVarietal() {
        List<Varietal> varietalDescripcion = this.varietal;
        List<String> descripcion = new ArrayList();
        for (Varietal varietal : varietalDescripcion) {
            descripcion.add(varietal.getDescripcion());}
        return descripcion;
    }

    float calcularPuntajeSommelierEnPeriodo(String fechaDesde, String fechaHasta) {
        List<Reseña> resenaArray = this.resena;
        int suma = 0;
        int cuenta = 0;
        for (Reseña resena : resenaArray) {
            if (resena.esPremium() && resena.esDelPeriodo(fechaDesde, fechaHasta)){
                suma += resena.getPuntaje();
                cuenta++;}}
        return calcularPromedio(suma, cuenta);
    }

    private float calcularPromedio(int suma, int cuenta) {
        float promedio = -1;
        if (cuenta != 0){
            promedio = (float) suma/(float) cuenta;}
        return promedio;
    }
}