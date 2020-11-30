/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Papeleo.*;
import java.util.*;
import Eventos.*;
import java.text.SimpleDateFormat;

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
                    System.out.println("/********************************************************/\n");

                    System.out.println(planificador.ListaSolicitud);
                    int contador = 1;

                    for (Solicitud solicitud : ListaSolicitud) {
                        System.out.println("" + contador + ". " + solicitud.getId()+" - "+new SimpleDateFormat("dd/MM/yyyy").format(solicitud.getFechaEvento()));
                        contador += 1;

                    }
                    break;
                case 2: 
                     
                    System.out.println("Ingrese el id de la solicitud: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    for (Solicitud solicitud: ListaSolicitud){
                        if (solicitud.getId() == id){                           
                            solicitud.toString();
                            System.out.println("/****************  REGISTRO DE DATOS DEL EVENTO  ****************/");
                            
                            System.out.println("Hora de inicio: ");
                            String horaInicio = sc.nextLine();
                            System.out.println("Hora fin: ");
                            String horaFin = sc.nextLine();
                            
                            switch(solicitud.getTipoEvento()){
                                case BODA:
                                    System.out.println("Tipo vehículo: ");
                                    String tipoVehiculo = sc.nextLine();
                                    
                                    // CREAR BODA
                                    
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    String agregarAdicional = sc.nextLine();
                                    
                                    if (agregarAdicional.equals("S")){
                                        
                                      // AGREGAR ADICIONALES PARA BODA 
                                        
                                    }
                                    
                                    
                                    break;
                                case FIESTAINFANTIL:
                                    System.out.println("Cantidad personajes disfrazados: ");
                                    int personajesDis = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Cantidad sorpresas: ");
                                    int sorpresas = sc.nextInt();
                                    sc.nextLine();
                                    
                                    break;
                                case FIESTAEMPRESARIAL:
                                    
                                    System.out.println("¿Desea transporte? (S/N): ");
                                    String trans = sc.nextLine();
                                    boolean transporte;
                                    
                                    switch (trans){
                                        case "S":
                                            transporte = true;
                                            
                                            
                                            break;
                                        case "N":
                                            transporte = false;
                                            
                                            break;
                                            
                                        default:
                                            break;
                                    }
                                    
                                    break;
                                
                            }
                            
                        }
                        
                    }
                    
                    
                    
                    break;
                

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
