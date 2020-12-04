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

    public ArrayList<Solicitud> getListaSolicitud() {
        return ListaSolicitud;
    }

    /*Menu de ingreso para el planificador*/
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

                    int contador = 1;

                    for (Solicitud solicitud : ListaSolicitud) {
                        if (solicitud.getEstadoSolicitud().equals(EstadoSolicitud.PENDIENTE)) {
                            System.out.println("" + contador + ". " + solicitud.getId() + " - " + new SimpleDateFormat("dd/MM/yyyy").format(solicitud.getFechaEvento()));
                            contador += 1;
                        }

                    }
                    break;
                case 2:

                    System.out.println("Ingrese el id de la solicitud: ");
                    String id = sc.nextLine();

                    for (Solicitud solicitud : ListaSolicitud) {
                        if ((solicitud.getId().equals(id)) && (solicitud.getEstadoSolicitud().equals(EstadoSolicitud.PENDIENTE))) {
                            solicitud.toString();
                            String agregarAdicional;
                            System.out.println("/****************  REGISTRO DE DATOS DEL EVENTO  ****************/");

                            System.out.println("Hora de inicio: (HH:MM) ");
                            String horaInicio = sc.nextLine();
                            System.out.println("Hora fin: (HH:MM) ");
                            String horaFin = sc.nextLine();
                            System.out.println("Capacidad: ");
                            int capacidad = sc.nextInt();
                            sc.nextLine();
                            Evento evento;
                            String eleccionOrdenPago;

                            switch (solicitud.getTipoEvento()) {
                                case BODA:
                                    System.out.println("Tipo vehículo: ");
                                    String tipoVehiculo = sc.nextLine();

                                    // CREAR BODA
                                    Boda boda = new Boda(solicitud.getCliente(), planificador, solicitud.getFechaEvento(), horaInicio, horaFin, capacidad, solicitud, tipoVehiculo);// CREAR OBJETO BODA

                                    // AGREGANDO ELEMENTOS ADICIONALES
                                    System.out.println("/*-------------------------------------------------------------*/");
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    agregarAdicional = sc.nextLine();

                                    if (agregarAdicional.equals("S")) {
                                        int eleccion = 0;
                                        do {// Mostrar Menú adicional: 
                                            eleccion = boda.mostrarMenuAdicional();
                                            boda.guardarAdicional(eleccion);
                                        } while (eleccion != 6);// AGREGAR ADICIONALES PARA BODA                                     
                                    }

                                    System.out.println("Ha concluido el ingreso de los datos del evento");
                                    System.out.println("El costo total de su evento será " + boda.getPrecio() + " dólares.");
                                    System.out.println("¿Desea generar su orden de pago? (S/N)");
                                    eleccionOrdenPago = sc.nextLine();
                                    // Método generar orden de pago del evento. 
                                    if (eleccionOrdenPago.equals("S")) {
                                        OrdenPago ordenPago = new OrdenPago(boda.getCliente(), boda, boda.getFechaEvento(), boda.getArrayAdicionales(), boda.getPrecio());
                                        ordenPago.guardarOrdenPago();
                                        ordenPago.mostrarDatosPago();

                                    }
                                    ListaEventos.add(boda);
                                    solicitud.getCliente().setListaEventos(boda);
                                    Evento.crearEvento(boda);
                                    Evento.crearAdicional(boda);

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

                                    FiestaInfantil fiestaInfantil = new FiestaInfantil(solicitud.getCliente(), planificador, solicitud.getFechaEvento(), horaInicio, horaFin, capacidad, solicitud, personajesDis, sorpresas, juegosFiesta);// CREAR OBJETO BODA

                                    // AGREGANDO ELEMENTOS ADICIONALES
                                    System.out.println("/*-------------------------------------------------------------*/");
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    agregarAdicional = sc.nextLine();

                                    if (agregarAdicional.equals("S")) {
                                        int eleccion = 0;
                                        do {// Mostrar Menú adicional: 
                                            eleccion = fiestaInfantil.mostrarMenuAdicional();
                                            fiestaInfantil.guardarAdicional(eleccion);
                                        } while (eleccion != 6);// AGREGAR ADICIONALES PARA FI                                     
                                    }

                                    System.out.println("Ha concluido el ingreso de los datos del evento");
                                    System.out.println("El costo total de su evento será " + fiestaInfantil.getPrecio() + " dólares.");
                                    System.out.println("¿Desea generar su orden de pago? (S/N)");
                                    eleccionOrdenPago = sc.nextLine();
                                    // Método generar orden de pago del evento. 
                                    if (eleccionOrdenPago.equals("S")) {
                                        OrdenPago ordenPago = new OrdenPago(fiestaInfantil.getCliente(), fiestaInfantil, fiestaInfantil.getFechaEvento(), fiestaInfantil.getArrayAdicionales(), fiestaInfantil.getPrecio());
                                        ordenPago.guardarOrdenPago();
                                        ordenPago.mostrarDatosPago();

                                    }
                                    ListaEventos.add(fiestaInfantil);
                                    Evento.crearEvento(fiestaInfantil);
                                    Evento.crearAdicional(fiestaInfantil);

                                    break;

                                case FIESTAEMPRESARIAL:

                                    System.out.println("¿Desea transporte? (S/N): ");
                                    String transporte = sc.nextLine();

                                    FiestaEmpresarial fiestaEmpresarial = new FiestaEmpresarial(solicitud.getCliente(), planificador, solicitud.getFechaEvento(), horaInicio, horaFin, capacidad, solicitud, transporte);// CREAR OBJETO BODA

                                    // AGREGANDO ELEMENTOS ADICIONALES
                                    System.out.println("/*-------------------------------------------------------------*/");
                                    System.out.println("¿Desea agregar elementos adicionales? (S/N)");
                                    agregarAdicional = sc.nextLine();

                                    if (agregarAdicional.equals("S")) {
                                        int eleccion = 0;
                                        do {// Mostrar Menú adicional: 
                                            eleccion = fiestaEmpresarial.mostrarMenuAdicional();
                                            fiestaEmpresarial.guardarAdicional(eleccion);
                                        } while (eleccion != 6);// AGREGAR ADICIONALES PARA FI                                     
                                    }

                                    System.out.println("Ha concluido el ingreso de los datos del evento");
                                    System.out.println("El costo total de su evento será " + fiestaEmpresarial.getPrecio() + " dólares.");
                                    System.out.println("¿Desea generar su orden de pago? (S/N)");
                                    eleccionOrdenPago = sc.nextLine();
                                    // Método generar orden de pago del evento. 
                                    if (eleccionOrdenPago.equals("S")) {
                                        OrdenPago ordenPago = new OrdenPago(fiestaEmpresarial.getCliente(), fiestaEmpresarial, fiestaEmpresarial.getFechaEvento(), fiestaEmpresarial.getArrayAdicionales(), fiestaEmpresarial.getPrecio());
                                        ordenPago.guardarOrdenPago();
                                        ordenPago.mostrarDatosPago();

                                    }
                                    ListaEventos.add(fiestaEmpresarial);
                                    Evento.crearEvento(fiestaEmpresarial);
                                    Evento.crearAdicional(fiestaEmpresarial);
                                    solicitud.getCliente().setListaEventos(fiestaEmpresarial);

                                    break;
                            }

                            solicitud.setEstadoSolicitud(EstadoSolicitud.APROBADO);
                        }
                    }
                    break;
                case 3:
                    System.out.println("/******************* CONFIRMAR EVENTO *******************/");
                    System.out.println("/*                                                      */");
                    System.out.println("/********************************************************/\n");
                    System.out.println("Ingrese el id de la orden de Pago: ");
                    int idPago = sc.nextInt();
                    sc.nextLine();
                    System.out.println(ListaOrdenesPago);
                    
                    for ( OrdenPago ordenPago: ListaOrdenesPago){
                        if ((idPago == ordenPago.getId())&& (ordenPago.getEvento().getPlanificador().equals(planificador)) &&(ordenPago.getEstadoPago().equals(EstadoPago.PENDIENTEPAGO)) ){
                            System.out.println("El pago se ha realizado el: "+ordenPago.getFechaRegistroTransaccion());
                            System.out.println("¿Desea aprobar este pago? (S/N)");
                            String aprobarPago = sc.nextLine();
                            switch(aprobarPago){
                                case "S":
                                    System.out.println("El evento se ha confirmado para la fecha establecida");
                                    ordenPago.setEstadoPago(EstadoPago.CONFIRMADO);                           
                                    break;
                                case "N":
                                    System.out.println("No ha confirmado el evento.");
                                    break;
                                default:
                                    System.out.println("Debe ingresar una opción válida.");
                                    break;
                            }
                        }
                        else if ((idPago == ordenPago.getId()) && (ordenPago.getEvento().getPlanificador().equals(planificador)) &&(ordenPago.getEstadoPago().equals(EstadoPago.CONFIRMADO)) ){
                            System.out.println("Esta orden de pago ya ha sido confirmada. ");
                            
                        }
                        else {
                            System.out.println("No ha ingresado correctamente el ID.");
                        }
                    
                    }
                    
                    
                    

                    break;
                case 4:
                    System.out.println("/****************** CONSULTAR EVENTO9S ******************/");
                    System.out.println("/*                                                      */");
                    System.out.println("/********************************************************/\n");

                    System.out.println("TIPO DE EVENTOS \n"
                            + "1). Boda\n"
                            + "2). Fiesta Infaltil\n"
                            + "3). Fiesta Empresarial\n"
                            + "Elija el tipo de eventos que quiere consultar: ");

                    int elecTipoEven = sc.nextInt();
                    sc.nextLine();
                    int cantidad = 0;

                    for (Evento evento : ListaEventos) {
                        if ((elecTipoEven == 1) && (evento instanceof Boda)) {
                            cantidad += 1;
                        } else if ((elecTipoEven == 2) && (evento instanceof FiestaInfantil)) {
                            cantidad += 1;
                        } else if ((elecTipoEven == 3) && (evento instanceof FiestaEmpresarial)) {
                            cantidad += 1;
                        }

                        switch (elecTipoEven) {

                            case 1:
                                System.out.println("Tiene " + cantidad + " boda(s) asignadas");
                                break;
                            case 2:
                                System.out.println("Tiene " + cantidad + " fiesta(s) infaltil(es) asignadas");
                                break;
                            case 3:
                                System.out.println("Tiene " + cantidad + " fiesta(s) empresarial(es) asignadas.");
                                break;
                            default:
                                System.out.println("Ingrese el número correctamente");
                                break;

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
