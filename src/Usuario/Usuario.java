/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ablup
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private char tipo;

    public Usuario(String nombre, String apellido, String usuario, String contrasena, char tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    /*Metodo por el cual cargaremos todos los datos de los usuarios desde un 
      tipo de archivo*/
    public static void cargarArchivos(String nombrearchivo,ArrayList<Usuario> usuarios) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int i=1;
            String[] datos;
            while ((linea = br.readLine()) != null) {
                
                if(i!=1){
                    datos = linea.split(";");
                    usuarios.add(new Usuario(datos[0],datos[1],datos[2],datos[3],datos[4].charAt(0)));
                }
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        
        }finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        
        

    }
    
     /*Metodo para iniciar sesion*/
      public Usuario menuLogin(){
          
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("BIENVENIDO A EVENTPRO");
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("USUARIO: ");
        
        System.out.println("CONTRASEÑA: ");
        return null;
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrasena=" + contrasena + ", tipo=" + tipo + '}';
    }
    
    //Metodos por agregar
    
  
}
