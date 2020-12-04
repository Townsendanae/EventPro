/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Papeleo.*;
import java.util.*;
import Eventos.*;
import eventproaplicacion.EventProAplicacion;
import java.text.SimpleDateFormat;

/**
 *
 * @author ablup
 */
public class Planificador extends Usuario {

    private static ArrayList<Evento> ListaEventos = new ArrayList<Evento>();
    private static ArrayList<Solicitud> ListaSolicitud = new ArrayList<Solicitud>();
    Scanner sc = new Scanner(System.in);

    //---- Constructores ----
    public Planificador(String nombre, String apellido, String usuario, String contrasena, char tipo, ArrayList<Solicitud> listaSolicitud) {
        super(nombre, apellido, usuario, contrasena, tipo);
        this.ListaSolicitud = listaSolicitud;
    }

    public Planificador(String nombre, String apellido, String usuario, String contrasena, char tipo) {
        super(nombre, apellido, usuario, contrasena, tipo);
    }

    public static void setListaSolicitud(Solicitud solicitud) {
        ListaSolicitud.add(solicitud);
    }

    public static ArrayList<Solicitud> getListaSolicitud() {
        return ListaSolicitud;
    }
    
    
    /*Menu de ingreso para el planificador*/
    public boolean menuPlanificador(Planificador planificador) {
        String agregarAdicional;
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
                    String id = sc.nextLine();
                    
                    
                    for (Solicitud solicitud: ListaSolicitud){
                        if (solicitud.getId().equals(id)){                           
                            solicitud.toString();
                            System.out.println("/****************  REGISTRO DE DATOS DEL EVENTO  ****************/");
                            
                            System.out.println("Hora de inicio: ");
                            String horaInicio = sc.nextLine();
                            System.out.println("Hora fin: ");
                            String horaFin = sc.nextLine();
                            System.out.println("Capacidad: ");
                            int capacidad = sc.nextInt();
                            sc.nextLine();
                            
                           
                            switch(solicitud.getTipoEvento()){
                                case BODA:
                                    System.out.println("Tipo vehículo: ");
                                    String tipoVehiculo = sc.nextLine();
                                    
                                    // CREAR BODA
                                    Boda boda = new Boda(solicitud.getCliente(),solicitud.getPlanificador(),
                                            solicitud.getFechaEvento(),horaInicio,horaFin,capacidad,tipoVehiculo);
                                    
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    agregarAdicional = sc.nextLine();
                                    
                                      // AGREGAR ADICIONALES PARA BODA 
                                    if (agregarAdicional.equals("S")){
                                       Evento.menu();
                                       int eleccion = sc.nextInt();
                                       sc.nextLine();
                                       boda.guardarAdicional(eleccion);
                                       
                                      
                                        
                                    }
                                    ListaEventos.add(boda);
                                    Evento.crearEvento(boda);
                                    
                                    
                                    break;
                                case FIESTAINFANTIL:
                                    System.out.println("Cantidad personajes disfrazados: ");
                                    int personajesDis = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Cantidad sorpresas: ");
                                    int sorpresas = sc.nextInt();
                                    sc.nextLine();
                                    
                                    FiestaInfantil fiestaInfantil = new FiestaInfantil(solicitud.getCliente(), solicitud.getPlanificador(),solicitud.getFechaEvento(),
                                            horaInicio, horaFin, capacidad, personajesDis, sorpresas, true);
                                    //AGREGANDO ELEMENTOS ADICIONALES
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    agregarAdicional = sc.nextLine();
                                    
                                    if (agregarAdicional.equals("S")){
                                       Evento.menu();
                                       int eleccion = sc.nextInt();
                                       sc.nextLine();
                                       fiestaInfantil.guardarAdicional(eleccion);
                                       
                                       
                                    }
                                    ListaEventos.add(fiestaInfantil);
                                    Evento.crearEvento(fiestaInfantil);
                                    break;
                                    
                                case FIESTAEMPRESARIAL:
                                    
                                    System.out.println("¿Desea transporte? (S/N): ");
                                    String trans = sc.nextLine();
                                    boolean transporte = false;
                                    
                                    if(trans.charAt(0)=='S')
                                        transporte=true;
                                    System.out.println("Ingrese la cantidad de personas: ");
                                    int cantidadPersonas=sc.nextInt();
                                    sc.nextLine();
                                    FiestaEmpresarial fiestaEmpresarial = new FiestaEmpresarial(solicitud.getCliente(), solicitud.getPlanificador(), solicitud.getFechaEvento(),
                                                horaInicio, horaFin, capacidad, transporte, cantidadPersonas);
                                    //AGREGANDO ELEMENTOS ADICIONALES
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    agregarAdicional = sc.nextLine();
                                    
                                    if (agregarAdicional.equals("S")){
                                       Evento.menu();
                                       int eleccion = sc.nextInt();
                                       sc.nextLine();
                                       fiestaEmpresarial.guardarAdicional(eleccion);
                                       
                                    }
                                    ListaEventos.add(fiestaEmpresarial);
                                    Evento.crearEvento(fiestaEmpresarial);
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
    
    
    
//    private static void cargarSolicitudes(String nombreArchivo) {
//        
//        ArrayList<String> lineas = EventProAplicacion.cargarArchivos("usuarios.txt");
//        ArrayList<String> lineas2 = EventProAplicacion.cargarArchivos("solicitud.txt");
//        ArrayList<String> lineas3 = EventProAplicacion.cargarArchivos("clientes.txt");
//        
//        for (String linea : lineas2) { // crear Usuarios. 
//            if (!linea.equals("id_solicitud,nombre_cliente,nombre_planificador,fecha_solicitud,fecha_evento,estado")) { //Recorremos archivo de solicitudes. 
//                String[] datosSolicitud = linea.split(",");
//                Solicitud solicitud = new Solicitud();
//                    for (String lineaUsuario : lineas) {//Recorremos los usuarios
//                        
//                        if (!lineaUsuario.equals("Nombre;Apellido;Usuario;Contrasena;Tipo")) {
//                            String[] datosCliente = lineaUsuario.split(";");
//                            
//                            if(datosSolicitud[4].equals(datosCliente[0])){
//                                for(String lineaCliente: lineas3){//recorremos los clientes
//                                    if(!lineaCliente.equals("Usuario;telefono;mail")){
//                                        
//                                        String[] datosCliente2 = lineaCliente.split(";");
//                                        if(datosCliente2[0].equals(datosCliente[2])){
//                                                solicitud.setCliente(new Cliente(datosCliente[0],datosCliente[1],datosCliente[2],
//                                                datosCliente[3],datosCliente[4].charAt(0),datosCliente2[1],datosCliente2[2]));
//                                        }
//                                    }
//                                }
//                            }else if(datosSolicitud[2].equals(datosCliente[0])){
//                                solicitud.setPlanificador(new Planificador(datosCliente[0],datosCliente[1],datosCliente[2],
//                                datosCliente[3],datosCliente[4].charAt(0)));
//                            
//                            }
//                            solicitud.setId(datosSolicitud[0]);
//                            solicitud.setPrecioBase(0);
//                            
//                                
//                            ListaSolicitud.add(new Solicitud(datos[0], datos[1], datos[2], null, datos[4].charAt(0), datosCliente[1], datosCliente[2]));
//                        }
//                    }
//                
//            }
//        }
//        
//        
//
//    }
    
    

}
