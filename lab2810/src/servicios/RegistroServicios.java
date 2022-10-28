/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            insert= conexion.prepareStatement("INSERT INTO registro VALUES(?,?,?,?,?)");
            insert.setString(1, v.getPlaca());
            insert.setDate(2, v.getFecha());
            insert.setInt(3, v.getModelo());
            insert.setInt(5, v.getTipo());
            insert.setInt(5, v.getValor());
            insert.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }

    public static boolean isRepetida(String placa, Connection conexion) throws SQLException {

        try {
            PreparedStatement select;
            select = conexion.prepareStatement("SELECT FROM registro WHERE placa='" + placa + "'");
            ResultSet rs = select.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

    }
}
