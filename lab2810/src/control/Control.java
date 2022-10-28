/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import vista.vista;

/**
 *
 * @author Estudiante
 */
public class Control implements ActionListener {

    vista vista;

    public Control(vista vista) {
        this.vista = vista;
        vista.jTextField3.setText(new Date(System.currentTimeMillis()).toString());
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        setActionListener(this);
    }

    public void setActionListener(ActionListener control) {
        vista.jButton1.addActionListener(control);
        vista.jButton2.addActionListener(control);
        vista.jButton3.addActionListener(control);
        vista.jButton4.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar")) {

        } else if (e.getActionCommand().equals("Limpiar")) {
        } else if (e.getActionCommand().equals("Reiniciar")) {
        } else if (e.getActionCommand().equals("Totalizar")) {

        }

    }

}
