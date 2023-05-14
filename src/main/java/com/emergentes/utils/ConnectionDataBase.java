package com.emergentes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    
    // establecemos todos lo parametros para la conexion a la base de datos
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_biblio";
    static String user = "root";
    static String password = "19990809";
    
    //creamos la variable de tipo conexion
    Connection connection = null;
    
    public ConnectionDataBase() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de driver:; " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
        }
    }
    
    public Connection Connect() {
        return connection;
    }
    
    public void Disconnect() {
        try {
            connection.close();
            System.out.println("coneccion finalizada.");
        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }
}
