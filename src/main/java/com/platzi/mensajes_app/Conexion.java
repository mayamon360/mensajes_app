package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private Connection conexion;

    public Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_app?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true", "root", "admin");
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
        }

        return conexion;
    }

}
