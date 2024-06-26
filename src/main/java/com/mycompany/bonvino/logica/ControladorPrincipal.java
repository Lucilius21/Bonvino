package com.mycompany.bonvino.logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.bonvino.igu.Principal;
import com.mycompany.bonvino.igu.InterfazExcel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Declaracion de clase
public class ControladorPrincipal {
    private Principal principal;
    private TreeMap<Float, List<Vino>> vinosConPuntaje;
    
    public ControladorPrincipal(Principal principal) {
    
        this.principal = principal;
        this.vinosConPuntaje = new TreeMap<>(Collections.reverseOrder());
    }
    
    //Metodo para levantar datos
    public Vino [] mapearDatosVinosJSON(){
        Vino [] vinosArray = null;
        try{
            ObjectMapper m = new ObjectMapper();
            vinosArray = m.readValue(new File("datos.json"), Vino[].class);
        } catch(IOException e) {
        e.printStackTrace();
        }
        return vinosArray;
    }

    //Metodo para tomar las fechas desde VentanaGenerarReporte
    public void tomarFechas(String fechaDesde, String fechaHasta) throws IOException {
        //Esto es una prueba para ver que este recibiendo las fechas bien
        System.out.println(fechaDesde);
        System.out.println(fechaHasta);
        //Fin de prueba
        
        //Llamada al metodo de busqueda
        buscarVinosDeSommelierEnPeriodo(fechaDesde, fechaHasta);
    }
    
    //Busca todos los vinos que tengan reseñas que se hayan realizado en el 
    //periodo ingresado y que hayan sido realizadas por un Sommelier verificado 
    //en la aplicación.
    public void buscarVinosDeSommelierEnPeriodo(String fechaDesde, String fechaHasta) throws IOException{
        Vino[] vinosArray = mapearDatosVinosJSON();
        for (Vino vino : vinosArray){
            Boolean resenaValida = vino.tomarResenaSommelierEnPeriodo(fechaDesde, fechaHasta);
            String nombreVino = vino.getNombre();
            int precioVino = vino.getPrecio();
            List<String> infoBodega = vino.buscarInformacionBodega();
            List<String> descripcionVarietal = vino.buscarVarietal();
        }
        calcularPuntajeSommelierEnPeriodo(vinosArray, fechaDesde, fechaHasta);
        
        System.out.println(vinosConPuntaje);
        obtenerPrimeros10Vinos();
        }

    public void calcularPuntajeSommelierEnPeriodo(Vino[] vinosArray, String fechaDesde, String fechaHasta){
        for (Vino vino : vinosArray){
            float promedio = vino.calcularPuntajeSommelierEnPeriodo(fechaDesde, fechaHasta);
            if (promedio != -1){
                ordenarVinos(promedio, vino);};
        }
    }

    public void ordenarVinos(float promedio, Vino vino) {
        vinosConPuntaje.computeIfAbsent(promedio, v -> new ArrayList<>()).add(vino);
    }

    public void obtenerPrimeros10Vinos() throws IOException {
        InterfazExcel interfazExcel = new InterfazExcel();
        List<Vino> top10Vinos = new ArrayList<>();
        List<Float> puntajesPromedio = new ArrayList<>();
        for (Map.Entry<Float, List<Vino>> entrada : vinosConPuntaje.entrySet()) {
            List<Vino> vinosConMismoPuntaje = entrada.getValue();
            
            for (int i = 0; i < vinosConMismoPuntaje.size() && top10Vinos.size() < 10; i++) {
                top10Vinos.add(vinosConMismoPuntaje.get(i));
                puntajesPromedio.add(entrada.getKey());}
            
            if (top10Vinos.size() == 10) {
                break;
            }}
        interfazExcel.exportarExcel(top10Vinos, puntajesPromedio);
    }}