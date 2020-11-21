/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoconarchivos;

import java.util.Date;

/**
 *
 * @author Verónica
 */
public class TrabajoConArchivos {

  
    /**
     * @param args the command line arguments
     */
     public static void main(String[] arg) {
        ManejoArchivos.EscribirArchivo("archivosalida.txt","Hola");
        ManejoArchivos.EscribirArchivo("archivosalida.txt","Afios!");
        ManejoArchivos.LeeFichero("archivo.txt");

    }
    
}
