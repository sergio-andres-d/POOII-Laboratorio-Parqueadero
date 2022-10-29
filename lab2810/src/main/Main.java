/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import control.Control;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicios.Conexion;
import vista.vista;

/**
 *
 * @author Estudiante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        vista vista = new vista();
        try {
            Control control = new Control(vista, Conexion.getConexion());
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
