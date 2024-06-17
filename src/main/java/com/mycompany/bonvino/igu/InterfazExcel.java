package com.mycompany.bonvino.igu;

import com.mycompany.bonvino.logica.Vino;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InterfazExcel extends JFrame {
    public InterfazExcel() {
        setTitle("InterfazExcel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("El archivo Excel se ha generado correctamente.", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
    }
public void exportarExcel(List<Vino> top10Vinos, List<Float> puntajesPromedio) throws IOException {
  try (Workbook workbook = new XSSFWorkbook()) {
    Sheet hoja = workbook.createSheet("Top 10 Vinos");

    int rowNum = 0;

    // Crear fila de encabezado
    Row headerRow = hoja.createRow(rowNum);
    Cell cellNombre = headerRow.createCell(0);
    cellNombre.setCellValue("Nombre del Vino");

    Cell cellPrecio = headerRow.createCell(1);
    cellPrecio.setCellValue("Precio");

    Cell cellAnada = headerRow.createCell(2);
    cellAnada.setCellValue("Añada");

    Cell cellImagen = headerRow.createCell(3);
    cellImagen.setCellValue("Imagen");

    Cell cellNota = headerRow.createCell(4);
    cellNota.setCellValue("Nota de Cata");

    Cell cellPuntaje = headerRow.createCell(5);
    cellPuntaje.setCellValue("Puntaje Promedio");

    rowNum++; // Incrementar rowNum después de crear la fila de encabezado

    // Escribir filas de datos
    for (int i = 0; i < top10Vinos.size(); i++) {
      Vino vino = top10Vinos.get(i);
      float puntaje = puntajesPromedio.get(i);

      // Crear una nueva fila para cada dato de vino
      Row dataRow = hoja.createRow(rowNum);

      Cell cellNombreVino = dataRow.createCell(0);
      cellNombreVino.setCellValue(vino.getNombre());

      Cell cellPrecioVino = dataRow.createCell(1);
      cellPrecioVino.setCellValue(vino.getPrecio());

      Cell cellAnadaVino = dataRow.createCell(2);
      cellAnadaVino.setCellValue(vino.getAnada());

      
      Cell cellImagenVino = dataRow.createCell(3);
      cellImagenVino.setCellValue(vino.getImagen());

      Cell cellNotaVino = dataRow.createCell(4);
      cellNotaVino.setCellValue(vino.getNota());

      Cell cellPuntajeVino = dataRow.createCell(5);
      cellPuntajeVino.setCellValue(puntaje);

      rowNum++;
    }

    FileOutputStream outputStream = new FileOutputStream("Top10Vinos.xlsx");
    workbook.write(outputStream);
    outputStream.close();

  } catch (IOException e) {
    e.printStackTrace();
  }
}
}
