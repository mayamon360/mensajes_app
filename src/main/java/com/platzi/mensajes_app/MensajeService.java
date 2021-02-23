package com.platzi.mensajes_app;

import java.util.Scanner;

public class MensajeService {
    
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el mensaje:");
        String mensaje  = sc.nextLine();
        System.out.println("Escribe tu nombre:");
        String autor = sc.nextLine();
        Mensaje msj = new Mensaje(); 
        msj.setMensaje(mensaje);
        msj.setAutorMensaje(autor);
        
        MensajeDAO.crearMensaje(msj);
    }
    
    public static void listarMensajes() {
        MensajeDAO.leerMensajes();
    }
    
    public static void editarMensaje() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Indica el Id del mensaje a editar:");
        int idMensaje = Integer.parseInt(sc.nextLine());
        
        System.out.println("Indica el nuevo mensaje:");
        String mensaje = sc.nextLine();
 
        Mensaje msj = new Mensaje();
        msj.setIdMensaje(idMensaje);
        msj.setMensaje(mensaje);
        MensajeDAO.actualizarMensaje(msj);
    
    }
    
    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el Id del mensaje a borrar:");
        int idMensaje = sc.nextInt();
        MensajeDAO.borrarMensaje(idMensaje);
    }
    
}
