/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Papeleo.*;
import java.util.*;
import Eventos.*;
import static eventproaplicacion.EventProAplicacion.cargarArchivos;
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
        ArrayList<String> lineas;
        lineas = cargarArchivos("solicitud.txt");
        ArrayList<String> lineasClientes;
        // método para cvargar solicitudes. 
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

                    int contador = 1;

                    for (Solicitud solicitud : ListaSolicitud) {
                        System.out.println("" + contador + ". " + solicitud.getId() + " - " + new SimpleDateFormat("dd/MM/yyyy").format(solicitud.getFechaEvento()));
                        contador += 1;

                    }
                    break;
                case 2:

                    System.out.println("Ingrese el id de la solicitud: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    for (Solicitud solicitud : ListaSolicitud) {
                        if (solicitud.getId().equals(id)) {
                            solicitud.toString();
                            System.out.println("/****************  REGISTRO DE DATOS DEL EVENTO  ****************/");

                            System.out.println("Hora de inicio: ");
                            String horaInicio = sc.nextLine();
                            System.out.println("Hora fin: ");
                            String horaFin = sc.nextLine();
                            System.out.println("Capacidad: ");
                            int capacidad = sc.nextInt();
                            sc.nextLine();
                            Evento evento;
                            switch (solicitud.getTipoEvento()) {
                                case BODA:
                                    System.out.println("Tipo vehículo: ");
                                    String tipoVehiculo = sc.nextLine();

                                    evento = new Boda(solicitud.getCliente(), planificador, solicitud.getFechaEvento(), horaInicio, horaFin, capacidad, solicitud, tipoVehiculo);// CREAR OBJETO BODA
                                    ListaEventos.add(evento);
                                    System.out.println("/*-------------------------------------------------------------*/");
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    String adicionalBoda = sc.nextLine();

                                    if (adicionalBoda.equals("S")) {
                                        int eleccion = 0;
                                        do {// Mostrar Menú adicional: 
                                            eleccion = evento.mostrarMenuAdicional();
                                            evento.guardarAdicional(eleccion);
                                        } while (eleccion != 6);// AGREGAR ADICIONALES PARA BODA                                     
                                    }

                                    System.out.println("Ha concluido el ingreso de los datos del evento");
                                    System.out.println("El costo total de su evento será " + evento.getPrecio() + " dólares.");
                                    System.out.println("¿Desea generar su orden de pago? (S/N)");
                                    String eleccionOrden = sc.nextLine();
                                    // Método generar orden de pago del evento. 
                                    if (eleccionOrden.equals("S")) {
                                        OrdenPago ordenPago = new OrdenPago(evento.getCliente(), evento, evento.getFechaEvento(), evento.getArrayAdicionales(), evento.getPrecio());
                                        ordenPago.guardarOrdenPago();
                                    }

                                    break;
                                case FIESTAINFANTIL:
                                    System.out.println("Cantidad personajes disfrazados: ");
                                    int personajesDis = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Cantidad sorpresas: ");
                                    int sorpresas = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("¿Desea Juegos de fiesta? (S/N)");
                                    String juegosFiesta = sc.nextLine();

                                    evento = new FiestaInfantil(solicitud.getCliente(), planificador, solicitud.getFechaEvento(), horaInicio, horaFin, capacidad, solicitud, personajesDis, sorpresas, juegosFiesta);// CREAR OBJETO BODA
                                    ListaEventos.add(evento);
                                    System.out.println("/*-------------------------------------------------------------*/");
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    String adicionalFI = sc.nextLine();

                                    if (adicionalFI.equals("S")) {
                                        int eleccion = 0;
                                        do {// Mostrar Menú adicional: 
                                            eleccion = evento.mostrarMenuAdicional();
                                            evento.guardarAdicional(eleccion);
                                        } while (eleccion != 6);// AGREGAR ADICIONALES PARA FI                                     
                                    }

                                    System.out.println("Ha concluido el ingreso de los datos del evento");
                                    break;

                                case FIESTAEMPRESARIAL:

                                    System.out.println("¿Desea transporte? (S/N): ");
                                    String transporte = sc.nextLine();

                                    evento = new FiestaEmpresarial(solicitud.getCliente(), planificador, solicitud.getFechaEvento(), horaInicio, horaFin, capacidad, solicitud, transporte);// CREAR OBJETO BODA
                                    ListaEventos.add(evento);
                                    System.out.println("/*-------------------------------------------------------------*/");
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    String adicionalFE = sc.nextLine();

                                    if (adicionalFE.equals("S")) {
                                        int eleccion = 0;
                                        do {// Mostrar Menú adicional: 
                                            eleccion = evento.mostrarMenuAdicional();
                                            evento.guardarAdicional(eleccion);
                                        } while (eleccion != 6);// AGREGAR ADICIONALES PARA FI                                     
                                    }

                                    System.out.println("Ha concluido el ingreso de los datos del evento");
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
    
//    public void cargarSolicitudes(ArrayList<String> lineas, Planificador planificador){
//         for (String linea : lineas) { 
//            if (!linea.equals("id_solicitud,nombre_cliente,nombre_planificador,fecha_solicitud,fecha_evento,estado")) { //modificar para que no salga la primera linea. 
//                String[] datos = linea.split(",");
//                if (datos[2].equals(planificador.getNombre())) {
//                    Solicitud new solicitud = 
//                    ListaSolicitud.add(solicitud)
//                   
//                }
//            }
//        }
//        
//    }

}
