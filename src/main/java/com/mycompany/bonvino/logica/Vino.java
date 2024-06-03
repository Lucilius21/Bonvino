
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
            @JsonProperty("anada") int anada,
            @JsonProperty("imagenEtiqueta") String imagenEtiqueta,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("notaDeCataBodega") String notaDeCataBodega,
            @JsonProperty("precioARS") int precioARS,
            @JsonProperty("resena") List<Reseña> resena,
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

    String getNombre() {
        return this.nombre;
    }

    boolean tomarResenaSommelierEnPeriodo(String fechaDesde, String fechaHasta) {
        List<Reseña> resenaArray = this.resena;
        for (Reseña resena : resenaArray) {
            return resena.esDelPeriodo(fechaDesde, fechaHasta) && resena.esPremium();
                }
        return false;
    }

    int getPrecio() {
        return this.precioARS;
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
/*
    public Reseña TomarReseña(String fechaDesde, String fechaHasta) {
        try{
        ObjectMapper objectMapper = new ObjectMapper();
        Reseña [ ] resenaArray = objectMapper.readValue(new File("reseñas.json"), Reseña[ ].class);
        for (Reseña resena : resenaArray){
        //aca llamo a Reseña y le pregunto cosas
            if (resena.sosDePeriodo(fechaDesde, fechaHasta) && resena.esPremium() && resena.getIdVino() == this.idVino) {
                return resena;
            }
        }
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }
    public float getPrecio(){
        return precioARS;
    }

 public List<String> buscarInformacionBodega() { 
      List<String> bodegaInfo = new ArrayList<>();   
     try {
            ObjectMapper objectMapper = new ObjectMapper();
            Bodega [ ] bodegaArray = objectMapper.readValue(new File("bodegas.json"), Bodega[ ].class);
            for (Bodega bodega : bodegaArray){
                if (bodega.getIdBodega() == this.idBodega){
                    bodegaInfo.add(bodega.getNombre());
                    List<String> regionPais = bodega.getRegionYPais();
                    bodegaInfo.add(regionPais.get(0));
                    bodegaInfo.add(regionPais.get(1));
                }  
            }
           
        } catch (IOException ex) {
            Logger.getLogger(Vino.class.getName()).log(Level.SEVERE, null, ex);
        }
         return bodegaInfo;
 }

    int getId() {
        return this.idVino;
    }

    List<String> buscarVarietal() {
        List<String> varietalInfo = new ArrayList<>();
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        Varietal [ ] varietalArray = objectMapper.readValue(new File("varietal.json"), Varietal[ ].class);
        for (Varietal varietal : varietalArray){
            if (this.idVino == varietal.getId()){
                varietalInfo.add(varietal.getDescripcion());
        }
        }
        }catch(IOException e){
        e.printStackTrace();
        }
        return null;
    }

    int calcularPuntajeSommelierEnPeriodo(String fechaDesde, String fechaHasta) {
        int promedio = 0;
        try {
        int puntaje = 0;
        int contador = 0;
        ObjectMapper objectMapper = new ObjectMapper();
        Reseña [ ] resenaArray = objectMapper.readValue(new File("reseñas.json"), Reseña[ ].class);
        for (Reseña resena : resenaArray){
        //aca llamo a Reseña y le pregunto cosas
            if (resena.sosDePeriodo(fechaDesde, fechaHasta) && resena.esPremium() && resena.getIdVino() == this.idVino) {
                puntaje += resena.getPuntaje();
                contador++;
        }}
        promedio = calcularPromedio(puntaje, contador);
        return promedio;
        }catch(IOException e){
        e.printStackTrace();
        }
        return promedio;
    }
 

    private int calcularPromedio(int puntaje, int contador) {
        int promedio = 0;
        if (contador != 0){
            promedio = puntaje / contador;
        }
    return Math.round(promedio);
    }

    int getAnada() {
        return this.anada;
    }

    String getImagen() {
        return this.imagenEtiqueta;
    }

    String getNota() {
        return this.notaDeCataBodega;
    }

    int getIdBodega() {
        return this.idBodega;
    }
}

*/