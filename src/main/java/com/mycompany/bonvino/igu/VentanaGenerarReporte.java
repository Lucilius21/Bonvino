package com.mycompany.bonvino.igu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.mycompany.bonvino.logica.ControladorPrincipal;

public class VentanaGenerarReporte extends javax.swing.JFrame {
    
    private ControladorPrincipal controlador;
    /**
     * Creates new form VentanaGenerarReporte
     */
    public VentanaGenerarReporte(ControladorPrincipal controlador) {
        initComponents();
        this.controlador = controlador;
    }
    
    public void setControlador(ControladorPrincipal controlador) {
        this.controlador = controlador;
    }

    // Métodos de validación de fechas
    private boolean isValidDateFormat(String date) {
        String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            Date parsedDate = sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    private boolean areDatesConsistent(String dateFrom, String dateTo) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date from = sdf.parse(dateFrom);
            Date to = sdf.parse(dateTo);
            return !from.after(to);
        } catch (ParseException e) {
            return false;
        }
    }

// Método de manejo del evento de confirmación
private void solicitarConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    String fechaDesde = solicitarFechaDesde.getText();
    String fechaHasta = solicitarFechaHasta.getText();
    

    if (!isValidDateFormat(fechaDesde) || !isValidDateFormat(fechaHasta)) {
        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy.");
        return;
    }

    if (!areDatesConsistent(fechaDesde, fechaHasta)) {
        JOptionPane.showMessageDialog(this, "La fecha 'desde' no puede ser posterior a la fecha 'hasta'.");
        return;
    }
    // Envío de las fechas al ControladorPrincipal si está disponible
    if (controlador != null) {
        controlador.tomarFechas(fechaDesde, fechaHasta);
    }
} // Aquí se cierra el método solicitarConfirmacionActionPerformed

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        solicitarFechaHasta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        solicitarFechaDesde = new javax.swing.JTextField();
        solicitarTipoReseña = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        solicitarConfirmacion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        solicitarTipoVisualizacion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("GENERAR REPORTE");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Downloads\\iconosBonvino\\iconoflecha.png")); // NOI18N

        jLabel3.setText("Fecha desde");

        solicitarFechaHasta.setText("dd/MM/yyyy");
        solicitarFechaHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarFechaHastaActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha hasta");

        solicitarFechaDesde.setText("dd/MM/yyyy");
        solicitarFechaDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarFechaDesdeActionPerformed(evt);
            }
        });

        solicitarTipoReseña.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sommelier", "Enófilo", "Amigos" }));

        jLabel5.setText("Seleccione Tipo de Reseña");

        solicitarConfirmacion.setBackground(new java.awt.Color(0, 102, 204));
        solicitarConfirmacion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        solicitarConfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        solicitarConfirmacion.setText("CONFIRMAR");
        solicitarConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitarConfirmacionActionPerformed(evt);
            }
        });

        jLabel6.setText("Selecciones Tipo de Visualización");

        solicitarTipoVisualizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excel", "Pdf" }));
        solicitarTipoVisualizacion.setSelectedItem(getTitle());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(solicitarFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solicitarFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(solicitarTipoReseña, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(solicitarTipoVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(157, 157, 157))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(solicitarConfirmacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(solicitarFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solicitarTipoReseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(solicitarFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solicitarTipoVisualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(solicitarConfirmacion)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(253, 253, 253)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(98, 98, 98)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void solicitarFechaHastaActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void solicitarFechaDesdeActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton solicitarConfirmacion;
    private javax.swing.JTextField solicitarFechaDesde;
    private javax.swing.JTextField solicitarFechaHasta;
    private javax.swing.JComboBox<String> solicitarTipoReseña;
    private javax.swing.JComboBox<String> solicitarTipoVisualizacion;
    // End of variables declaration                   
}
