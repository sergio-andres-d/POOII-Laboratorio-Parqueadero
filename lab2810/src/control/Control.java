/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Year;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Vehiculo;
import servicios.RegistroServicios;
import vista.vista;
import servicios.RegistroServicios;

/**
 *
 * @author Estudiante
 */
public class Control implements ActionListener {

    vista vista;
    Connection conexion;

    public Control(vista vista, Connection conexion) throws SQLException {
        this.conexion = conexion;
        this.vista = vista;
        vista.jTextField3.setText(new Date(System.currentTimeMillis()).toString());
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        try {
            setActionListener(this);
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    public void setActionListener(ActionListener control) throws SQLException {
        vista.jButton1.addActionListener(control);
        vista.jButton2.addActionListener(control);
        vista.jButton3.addActionListener(control);
        vista.jButton4.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Agregar")) {
            try {
                String placa = vista.jTextField1.getText();
                if (placa.length() == 6 && vista.jComboBox1.getSelectedItem().equals("Carro")
                        || placa.length() == 5 && vista.jComboBox1.getSelectedItem().equals("Moto")) {
                    if (!RegistroServicios.isRepetida(placa, conexion)) {
                        short modelo = (short) Integer.parseInt(vista.jTextField2.getText());
                        Date fecha = Date.valueOf(vista.jTextField3.getText());
                        byte tipo = 0;
                        short valor = 0;
                        if (vista.jComboBox1.getSelectedItem().equals("Carro")) {
                            tipo = 1;
                            if (modelo < 2012) {
                                valor = 2000;
                            } else if (Integer.parseInt(Year.now().toString()) == modelo) {
                                valor = (short) (2500 * 1.2);
                            } else {
                                valor = 2500;
                            }
                            
                        } else if (vista.jComboBox1.getSelectedItem().equals("Moto")) {
                            tipo = 2;
                            if (modelo < 2012) {
                                valor = 1000;
                            } else if (Integer.parseInt(Year.now().toString()) == modelo) {
                                valor = (short) (1200 * 1.1);
                            } else {
                                valor = 1200;
                            }
                        }
                        Vehiculo v = new Vehiculo(placa, modelo, valor, tipo, fecha);
                        RegistroServicios.agregar(v, conexion);
                        vista.jTextField5.setText(RegistroServicios.totalCarros(conexion)+"");
                        vista.jTextField4.setText(RegistroServicios.totalMotos(conexion)+"");
                    } else {
                        System.out.println("La placa ya esta registrada");
                    }
                } else {
                    System.out.println("La placa no es el de tamaño correcto");
                }
            } catch (SQLException ex) {
            }
        } else if (e.getActionCommand().equals("Limpiar")) {
            vista.jTextField1.setText("");
            vista.jTextField2.setText("");
        } else if (e.getActionCommand().equals("Reiniciar")) {
            try {
                vista.jTextField4.setText("");
                vista.jTextField5.setText("");
                RegistroServicios.limpiarRegistro(new Date(System.currentTimeMillis()), conexion);
            } catch (SQLException ex) {
            }
        } else if (e.getActionCommand().equals("Totalizar")) {
            try {
                vista.jTextArea1.setText("");
                vista.jTextArea1.append("El total de carros es "+RegistroServicios.numCarros(conexion)+" con un valor de "+RegistroServicios.totalCarros(conexion)+
                        ",\nel total de motos es "+RegistroServicios.numMotos(conexion)+" para un valor de "+RegistroServicios.totalMotos(conexion)+
                        ",\nel total de vehiculos es "+(RegistroServicios.numCarros(conexion)+RegistroServicios.numMotos(conexion))+
                        " y el total recaudado es "+(RegistroServicios.totalCarros(conexion)+RegistroServicios.totalMotos(conexion)));
            } catch (SQLException ex) {
            }
        }

    }

}
