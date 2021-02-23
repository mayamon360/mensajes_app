package com.platzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        
        do { 
            System.out.println("Selecciona una opcion:\n"
                    + "1. Crear mensaje\n"
                    + "2. Listar mensaje\n"
                    + "3. Editar mensaje\n"
                    + "4. Eliminar mensaje\n"
                    + "5. Salir\n");  
            opcion = sc.nextInt();
            
        } while(opcion != 5);
        
        switch(opcion) {
            case 1:
                MensajeService.crearMensaje();
                break;
            case 2:
                MensajeService.listarMensajes();
                break;
            case 3:
                MensajeService.editarMensaje();
                break;
            case 4:
                MensajeService.borrarMensaje();
                break;
            default:
                System.out.println("Seleccione una opción correcta");
                break;
        }
        
        
    }
}
