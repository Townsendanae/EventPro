/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Papeleo.Solicitud;
import java.util.*;
import Eventos.*;

/**
 *
 * @author ablup
 */
public class Planificador extends Usuario {

    private ArrayList<Evento> ListaEventos = new ArrayList<Evento>();
    private ArrayList<Solicitud> ListaSolicitud = new ArrayList<Solicitud>();
    Scanner sc = new Scanner(System.in);

    //---- Constructores ----
    public Planificador(String nombre, String apellido, String usuario, String contrasena, char tipo, ArrayList<Solicitud> listaSolicitud) {
        super(nombre, apellido, usuario, contrasena, tipo);
        this.ListaSolicitud = listaSolicitud;
    }

    public Planificador(String nombre, String apellido, String usuario, String contrasena, char tipo) {
        super(nombre, apellido, usuario, contrasena, tipo);
    }

    public void setListaSolicitud(Solicitud solicitud) {
        ListaSolicitud.add(solicitud);
    }

    public boolean menuPlanificador(Planificador planificador) {
        System.out.println("Bienvenido " + this.getNombre());
        System.out.println("\n 1. Consultar Solicitudes pendientes");
        System.out.println(" 2. Registrar evento");
        System.out.println(" 3. Confirmar evento");
        System.out.println(" 4. Consultar evento");
        System.out.println(" 5. Salir");

        System.out.println("Ingrese una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        while (opcion != 5) {
            switch (opcion) {

                case 1:
                    System.out.println("/**************** SOLICITUDES PENDIENTES ****************/");
                    System.out.println("/*                                                      */");
                    System.out.println("/********************************************************/");
                    
                    System.out.println(planificador.ListaSolicitud);

//                    for (int i = 0; i > ListaSolicitud.size(); i++) {
//                        System.out.println(i+1 + ". " + planificador.ListaSolicitud.get(i).toString());
//
//                    }

            }

            System.out.println("\n 1. Consultar Solicitudes pendientes");
            System.out.println(" 2. Registrar evento");
            System.out.println(" 3. Confirmar evento");
            System.out.println(" 4. Consultar evento");
            System.out.println(" 5. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

        }
        return true;

    }

}
