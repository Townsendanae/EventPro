/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventproaplicacion;

import Usuario.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.PrintWriter;
import java.io.*;
//import java.util.ArrayList;
import java.util.*;
import java.text.*;

/**
 *
 * @author danae
 */
public class EventProAplicacion {

    private static ArrayList<Usuario> usuarios = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> lineas;
        lineas = cargarArchivos("usuarios.txt");
        ArrayList<String> lineasClientes;
        lineasClientes = cargarArchivos("clientes.txt");
        CargarUsuarios(lineas, lineasClientes);

        boolean salirPrograma = false;

        do {
            Usuario user = EventProAplicacion.menuLogin();

            if (user.getTipo() == 'C') {
                boolean salirCliente = false;
                do {
                    System.out.println("Es un cliente"); //mostrar menú y opciones clientes, hacer método
                    Cliente userCliente = (Cliente) user;
                    salirCliente = userCliente.menuCliente(userCliente, usuarios);

                } while (!salirCliente);

            } else {
                boolean salirPlanificador = false;
                do {
                    System.out.println("Es un planificador"); //mostrar menú y opciones planificadores, hacer método. 
                    Planificador userPlanificador = (Planificador) user;
                    salirPlanificador = userPlanificador.menuPlanificador(userPlanificador);

                } while (!salirPlanificador);
            }

        } while (!salirPrograma);

        // TODO code application logic here
    }
        /*Metodo Para cargar la lista de usuarios*/
    private static void CargarUsuarios(ArrayList<String> lineas, ArrayList<String> lineasClientes) {
        for (String linea : lineas) { // crear Usuarios. 
            if (!linea.equals("Nombre;Apellido;Usuario;Contrasena;Tipo")) { //modificar para que no salga la primera linea. 
                String[] datos = linea.split(";");
                if (datos[4].equals("C")) {
                    for (String lineaCliente : lineasClientes) {
                        String[] datosCliente = lineaCliente.split(";");
                        if (datosCliente[0].equals(datos[2])) {
                            usuarios.add(new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4].charAt(0), datosCliente[1], datosCliente[2]));
                        }
                    }
                } else {
                    usuarios.add(new Planificador(datos[0], datos[1], datos[2], datos[3], datos[4].charAt(0)));
                }
            }
        }

    }

    /*Metodo para iniciar sesion*/
    private static Usuario menuLogin() {

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();
        System.out.println("BIENVENIDO A EVENTPRO");
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println();

        String nomUsuario, contrasena;
        boolean acceso = true;

        do {
            System.out.println("USUARIO: ");
            nomUsuario = sc.nextLine();
            System.out.println("CONTRASEÑA: ");
            contrasena = sc.nextLine();

            if (VerificarUsuario(nomUsuario, contrasena)) {
                acceso = false;
                for (Usuario usuario : usuarios) {
                    if (nomUsuario.equals(usuario.getUsuario())) {
                        return usuario;
                    }
                }
            } else {
                System.out.println("\n ******Usuario incorrecto*******\n");
            }

        } while (acceso);

        return null;
    }

    private static boolean VerificarUsuario(String nomUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if ((nomUsuario.equals(usuario.getUsuario())) && contrasena.equals(usuario.getContrasena())) {
                return true;
            }
        }
        return false;
    }

    /*Metodo por el cual cargaremos todos los datos de los usuarios desde un 
      tipo de archivo*/
    public static ArrayList<String> cargarArchivos(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null && (!linea.equals(""))) {
                //System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return lineas;

    }

    public static void sobreEscribirArchivos(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            bw.write(linea + "\n");
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
