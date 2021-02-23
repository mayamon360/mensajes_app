package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    public Connection getConexion() {
        Connection conexion = null;
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_app?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", "root", "admin");
            if(conexion != null) {
                System.out.println("Conexion exitosa!!");
            }
            
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        
        return conexion;
    }
    
}
