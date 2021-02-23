package com.platzi.mensajes_app;

import java.sql.Connection;

public class Inicio {
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConexion()) {
        
        } catch(Exception ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
