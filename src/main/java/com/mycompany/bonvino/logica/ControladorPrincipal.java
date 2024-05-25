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
    }
}

