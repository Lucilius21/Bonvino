/*package com.mycompany.bonvino.logica;

import com.mycompany.bonvino.igu.Principal;


public class ControladorPrincipal {
    public static void main(String[] args){
    Principal princ = new Principal();
    princ.setVisible(true);
    princ.setLocationRelativeTo(null);
    }

    // Método para tomar las fechas desde la ventanaGenerarReporte
    public void tomarFechas(String fechaDesde, String fechaHasta) {
        // Aquí puedes realizar las operaciones necesarias con las fechas obtenidas
        System.out.println("Fecha desde: " + fechaDesde);
        System.out.println("Fecha hasta: " + fechaHasta);
    }

} POR SI SE ROMPE FEROZMENTE
*/

package com.mycompany.bonvino.logica;

import com.mycompany.bonvino.igu.Principal;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ControladorPrincipal {
    private Principal principal;

    public ControladorPrincipal(Principal principal) {
        this.principal = principal;
    }

    // Método para tomar las fechas desde VentanaGenerarReporte
    public void tomarFechas(String fechaDesde, String fechaHasta) {
        // Aquí puedes realizar las operaciones necesarias con las fechas obtenidas
        System.out.println("Fecha desde: " + fechaDesde);
        System.out.println("Fecha hasta: " + fechaHasta);
        buscarVinos(fechaDesde, fechaHasta);
    }
    public List<Vino> buscarVinos(String fechaDesde, String fechaHasta){
    List<Vino> vinos = new ArrayList<>();
    try {
        Reseña resena;
        ObjectMapper objectMapper = new ObjectMapper();
        // esto convierte el json en un array de objetos vino
        Vino [ ] vinosArray = objectMapper.readValue(new File("vinos.json"), Vino[ ].class);
        for (Vino vino : vinosArray) {
            //aca llamo a vino y hago cosas
            resena = vino.TomarReseña(fechaDesde, fechaHasta); 
            //Si no hubo reseña que cumpliera nada
            if(resena == null){
            }
            //Si la reseña si cumple entonces si busca los datos
            else{
                if(vino.getId() == resena.getIdVino()){
                String nombreVino = vino.getNombre();
                float precioVino = vino.getPrecio();
                List<String> infoBodega = vino.buscarInformacionBodega();}}
        }
    } catch (IOException e){
        e.printStackTrace();
    }
    return vinos;
    }
    public void calcularPuntajeSommelierEnPeriodo(){
    
    }
}
        System.out.println("Fecha hasta: " + fechaHasta);
    }
}

