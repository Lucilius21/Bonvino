package com.mycompany.bonvino.logica;
import com.mycompany.bonvino.igu.InterfazExcel;
import com.mycompany.bonvino.igu.Principal;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    public void buscarVinos(String fechaDesde, String fechaHasta){
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
                List<String> infoBodega = vino.buscarInformacionBodega();
                List<String> varietal = vino.buscarVarietal();}}
        }
        calcularPuntajeSommelierEnPeriodo(fechaDesde, fechaHasta);
    } catch (IOException e){
        e.printStackTrace();
    }
    }
    public void calcularPuntajeSommelierEnPeriodo(String fechaDesde, String fechaHasta){
        try { 
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map.Entry<Integer, Vino>> vinosConPuntaje = new ArrayList<>();
            Vino [ ] vinosArray = objectMapper.readValue(new File("vinos.json"), Vino[ ].class);
            for ( Vino vino : vinosArray) {
                int promedio = vino.calcularPuntajeSommelierEnPeriodo(fechaDesde, fechaHasta);
                vinosConPuntaje.add(new AbstractMap.SimpleEntry<>(promedio, vino));
            }
        vinosConPuntaje.sort(Comparator.comparing(Map.Entry<Integer, Vino>::getKey).reversed());

        // Mantén solo los 10 mejores vinos
        List<Map.Entry<Integer, Vino>> top10Vinos = vinosConPuntaje.size() > 10 ? vinosConPuntaje.subList(0, 10) : vinosConPuntaje;

        // Imprimir los 10 mejores vinos
        for (Map.Entry<Integer, Vino> entry : top10Vinos) {
                System.out.println("Vino: " + entry.getValue().getNombre() + ", Puntaje: " + entry.getKey());
            }
        
        exportarExcel(top10Vinos, fechaDesde, fechaHasta);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void exportarExcel(List<Map.Entry<Integer, Vino>> topVinos, String fechaDesde, String fechaHasta) {
        try {
            // Crear un nuevo libro de Excel
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Top 10 Vinos");

            // Crear una fila para los encabezados
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "Nombre", "Anada", "Imagen de Etiqueta", "Nota De Cata Bodega", "precioARS", "idBodega", "Puntaje"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Escribir los datos en el archivo Excel
            for (int i = 0; i < topVinos.size(); i++) {
                Map.Entry<Integer, Vino> entry = topVinos.get(i);
                Vino vino = entry.getValue();
                int puntaje = entry.getKey();

                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(vino.getId());
                row.createCell(1).setCellValue(vino.getNombre());
                row.createCell(2).setCellValue(vino.getAnada());
                row.createCell(3).setCellValue(vino.getImagen());
                row.createCell(4).setCellValue(vino.getNota());
                row.createCell(5).setCellValue(vino.getPrecio());
                row.createCell(6).setCellValue(vino.getIdBodega());
                row.createCell(7).setCellValue(puntaje);
            }

            // Escribir el libro de Excel en un archivo
            FileOutputStream fileOut = new FileOutputStream("Top10Vinos.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

            System.out.println("El archivo Excel se ha generado correctamente.");
            // Abrir la ventana InterfazExcel
            InterfazExcel interfazExcel = new InterfazExcel();
            interfazExcel.setVisible(true);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
