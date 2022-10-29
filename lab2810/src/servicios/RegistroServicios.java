/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Vehiculo;

/**
 *
 * @author Estudiante
 */
public class RegistroServicios {

    public RegistroServicios(Vehiculo vehiculo) {

    }

    public static void agregar(Vehiculo v, Connection conexion) throws SQLException {
        try {
            PreparedStatement insert;
            insert= conexion.prepareStatement("INSERT INTO `registro` VALUES(?,?,?,?,?)");
            insert.setString(1, v.getPlaca());
            insert.setDate(2, v.getFecha());
            insert.setInt(3, v.getModelo());
            insert.setInt(4, v.getTipo());
            insert.setInt(5, v.getValor());
            insert.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    
    public static int totalCarros( Connection conexion) throws SQLException {
        try {
            PreparedStatement sum;
            sum= conexion.prepareStatement("SELECT SUM(valor) FROM `registro` WHERE tipo=1");
            ResultSet rs=sum.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    public static int numCarros( Connection conexion) throws SQLException {
        try {
            PreparedStatement sum;
            sum= conexion.prepareStatement("SELECT COUNT(*) FROM `registro` WHERE tipo=1");
            ResultSet rs=sum.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    public static int totalMotos( Connection conexion) throws SQLException {
        try {
            PreparedStatement sum;
            sum= conexion.prepareStatement("SELECT SUM(valor) FROM `registro` WHERE tipo=2");
            ResultSet rs=sum.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    public static int numMotos( Connection conexion) throws SQLException {
        try {
            PreparedStatement sum;
            sum= conexion.prepareStatement("SELECT COUNT(*) FROM `registro` WHERE tipo=2");
            ResultSet rs=sum.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    public static void limpiarRegistro(Date fecha, Connection conexion) throws SQLException {
        try {
            PreparedStatement insert;
            insert= conexion.prepareStatement("DELETE FROM `registro` WHERE fecha=?");
            insert.setDate(1, fecha);
            insert.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }

    public static boolean isRepetida(String placa, Connection conexion) throws SQLException {

        try {
            PreparedStatement select;
            select = conexion.prepareStatement("SELECT placa FROM `registro` WHERE placa=?"); 
            select.setString(1, placa);
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }

    }
}
