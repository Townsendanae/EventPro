/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventproaplicacion;

import Usuario.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danae
 */
public class EventProAplicacion {
    private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario.cargarArchivos("usuarios.txt", usuarios);
        System.out.println(usuarios);
        //EventProAplicacion.menuLogin();
        // TODO code application logic here
    }
    
  
    
    
     

    public static void sobreEscribirArchivos(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");
            System.out.println("ksdsdlsd");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
   
    
}
