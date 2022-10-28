/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Conexion {
    public static Connection conexion;
    
    public static Connection getConexion () throws ClassNotFoundException, SQLException{
        if(conexion==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion= DriverManager.getConnection("jdbc:mysql://localhost/parqueadero","root","");
            } catch (ClassNotFoundException ex) {
                throw new ClassNotFoundException(ex.getMessage());
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
            return conexion;
        }else return conexion;
    }
    public static void close() throws SQLException{
        if(conexion!=null) try {
            conexion.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
}
