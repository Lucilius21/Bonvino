
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
    int idVino;
    int anada;
    String imagenEtiqueta;
    String nombre;
    String notaDeCataBodega;
    float precioARS;
    int idBodega; //Identificador de bodega para el json bodega

    public Vino(@JsonProperty("id") int idVino,
            @JsonProperty("anada") int anada,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("imagenEtiqueta") String imagenEtiqueta,
            @JsonProperty("notaDeCataBodega") String notaDeCataBodega,
            @JsonProperty("precioARS") float precioARS,
            @JsonProperty("idBodega") int idBodega){
        this.anada = anada;
        this.imagenEtiqueta = imagenEtiqueta;
        this.notaDeCataBodega = notaDeCataBodega;
        this.nombre = nombre;
        this.precioARS = precioARS;
        this.idBodega = idBodega;
        this.idVino = idVino;
    }

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

