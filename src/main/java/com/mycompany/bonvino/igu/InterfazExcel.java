package com.mycompany.bonvino.igu;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class InterfazExcel extends JFrame {
    public InterfazExcel() {
        setTitle("InterfazExcel");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("El archivo Excel se ha generado correctamente.", JLabel.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
