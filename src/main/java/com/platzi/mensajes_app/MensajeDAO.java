package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {

    public static void crearMensaje(Mensaje mensaje) {

        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;

        try (Connection conexion = dbConnect.getConexion()) {

            try {

                String query = "INSERT INTO mensajes(mensaje, autor_mensaje) VALUES(?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado\n");

            } catch (SQLException ex) {
                System.out.println("No se puede registrar el mensaje en la BD: ");
                ex.printStackTrace(System.out);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

    public static void leerMensajes() {

        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = dbConnect.getConexion()) {

            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            System.out.println("Lista de mensajes:");

            while (rs.next()) {
                System.out.print("\t- ");
                System.out.print(rs.getInt("id_mensaje") + " ");
                System.out.print(rs.getString("mensaje") + " ");
                System.out.print(rs.getString("autor_mensaje") + " ");
                System.out.println(rs.getString("fecha_mensaje"));
            }

            System.out.println("");

        } catch (SQLException ex) {
            System.out.println("No se pudierón recuperar los mensajes: ");
            ex.printStackTrace(System.out);
        }

    }
    
    public static void actualizarMensaje(Mensaje mensaje) {
        
        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try (Connection conexion = dbConnect.getConexion()) {
            
            try {
                
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado\n");
                
            } catch (SQLException ex) { 
                ex.printStackTrace(System.out);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }

    public static void borrarMensaje(int idMensaje) {

        Conexion dbConnect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection conexion = dbConnect.getConexion()) {

            try {
                
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("Mensaje eliminado\n");

            } catch (SQLException ex) {
                System.out.println("No se pudo eliminar el mensaje " + idMensaje + ":");
                ex.printStackTrace(System.out);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
