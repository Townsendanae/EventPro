/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Eventos.Evento;
import java.util.*;
import eventproaplicacion.*;
import Papeleo.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ablup
 */
public class Cliente extends Usuario {

    private String celular;
    private String correo;
    private ArrayList<Evento> ListaEventos = new ArrayList<Evento>();
    Scanner sc = new Scanner(System.in);

    public Cliente(String nombre, String apellido, String usuario, String contrasena, char tipo, String celular, String correo) {
        super(nombre, apellido, usuario, contrasena, tipo);
        this.celular = celular;
        this.correo = correo;

    }

    public String getCelular() {
        return celular;
    }

    public void setListaEventos(Evento evento) {
        ListaEventos.add(evento);
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "celular=" + celular + ", correo=" + correo + '}';
    }

    //public Solicitud registrarSolicitud(){}
    //public void registrarPago(){}
    public boolean menuCliente(Cliente cliente, ArrayList<Usuario> usuarios) {

        System.out.println("\n 1. Solicitar planificacion de evento");
        System.out.println(" 2. Registrar pago evento");
        System.out.println(" 3. Salir");    
        
        String opcionString;
        do{
        System.out.println("Ingrese una opcion: ");
        opcionString = sc.nextLine();
        }while(opcionString.matches(".*[a-z].*"));
        int opcion = Integer.parseInt(opcionString);
        String op;

        while (opcion != 3) {

            switch (opcion) {
                case 1: // SOLICITAR PLANIFICACION EVENTO
                    System.out.println("/**************** NUEVA SOLICITUD ****************/");
                    System.out.println("/*                                               */");
                    System.out.println("/*************************************************/");
                    System.out.println("Bienvenido, " + cliente.getNombre());
                    System.out.println("TIPO DE EVENTO (Elija) ");
                    System.out.println("\n 1. Boda");
                    System.out.println(" 2. Fiesta Infantil");
                    System.out.println(" 3. Fiesta Empresarial");


                    String seleccionString;
                    do {
                        System.out.println("Seleccione: ");
                        seleccionString = sc.nextLine();
                    } while (seleccionString.matches(".*[a-z].*"));
                    int seleccion = Integer.parseInt(seleccionString);

                    String fechaEvento;
                    System.out.println("Ingresa fecha Evento: Ingrese formato dia/mes/año ");
                    fechaEvento = sc.nextLine();
                    switch (seleccion) {
                        case 1: // BODA               

                            while (!cliente.validarTiempo(fechaEvento, seleccion)) {
                                System.out.println("\n** La fecha es muy próxima. Para este tipo de evento debemos tener por lo menos 10 meses para planificar. Ingrese nuevamente \n");
                                System.out.println("Ingresa fecha Evento: Ingrese formato dia/mes/año ");
                                fechaEvento = sc.nextLine();
                            }
                            System.out.println("¡Fecha Válida!");

                            Solicitud solicitud_B = new Solicitud(cliente, new Date(), fechaEvento, usuarios, TipoEvento.BODA, 3500); // SE CREA LA SOLICITUD

                            System.out.println("Ha registrado todos los datos necesarios para la solicitud");
                            System.out.println("Desea registrar su solicitud:(S/N) ");

                            op = sc.nextLine().toUpperCase();
                            if (op.charAt(0) == 'S') {
                                for (Usuario usuario : usuarios) {
                                    if (usuario == solicitud_B.getPlanificador()) {
                                        solicitud_B.getPlanificador().setListaSolicitud(solicitud_B);
                                    }
                                }
                                Solicitud.crearSolicitud(solicitud_B);
                            } else {
                                System.out.println("Su solicitud no ha sido guardada");
                            }
                            break;

                        case 2: // FIESTA INTANTIL

                            while (!cliente.validarTiempo(fechaEvento, seleccion)) {
                                System.out.println("\n** La fecha es muy próxima. Para este tipo de evento debemos tener por lo menos 3 semanas para planificar. Ingrese nuevamente \n");
                                System.out.println("Ingresa fecha Evento: Ingrese formato dia/mes/año");
                                fechaEvento = sc.nextLine();
                            }
                            System.out.println("¡Fecha Válida!");
                            Solicitud solicitud_fi = new Solicitud(cliente, new Date(), fechaEvento, usuarios, TipoEvento.FIESTAINFANTIL, 300); // SE CREA LA SOLICITUDlicitud solicitud_FI = new Solicitud(cliente, new Date(), fechaEvento, usuarios, "Fiesta Infantil"); // SE CREA LA SOLICITUD

                            System.out.println("Ha registrado todos los datos necesarios para la solicitud");

                            System.out.println("Desea registrar su solicitud:(S/N) ");

                            op = sc.nextLine().toUpperCase();

                            if (op.charAt(0) == 'S') {
                                for (Usuario usuario : usuarios) {
                                    if (usuario == solicitud_fi.getPlanificador()) {
                                        solicitud_fi.getPlanificador().setListaSolicitud(solicitud_fi);
                                    }
                                }
                                Solicitud.crearSolicitud(solicitud_fi);
                            } else {
                                System.out.println("Su solicitud no ha sido guardada");
                            }

                            break;

                        case 3: // FIESTA EMPRESARIAL
                            while (!cliente.validarTiempo(fechaEvento, seleccion)) {
                                System.out.println("\n**La fecha es muy próxima. Para este tipo de evento debemos tener por lo menos 2 meses para planificar. Ingrese nuevamente. \n");
                                System.out.println("Ingresa fecha Evento: Ingrese formato dia/mes/año");
                                fechaEvento = sc.nextLine();
                            }
                            System.out.println("¡Fecha Válida!");
                            Solicitud solicitud_fem = new Solicitud(cliente, new Date(), fechaEvento, usuarios, TipoEvento.FIESTAEMPRESARIAL, 2000); // SE CREA LA SOLICITUD                        

                            System.out.println("Ha registrado todos los datos necesarios para la solicitud");
                            System.out.println("Desea registrar su solicitud:(S/N) ");

                            op = sc.nextLine().toUpperCase();
                            if (op.charAt(0) == 'S') {
                                for (Usuario usuario : usuarios) {
                                    if (usuario == solicitud_fem.getPlanificador()) {
                                        solicitud_fem.getPlanificador().setListaSolicitud(solicitud_fem);
                                    }
                                }
                                Solicitud.crearSolicitud(solicitud_fem);
                            } else {
                                System.out.println("Su solicitud no ha sido guardada");
                            }

                            break;
                    }
                    //System.out.println(Planificador.getListaSolicitud());
                    break;

                case 2: // REGISTRAR PAGO EVENTO
                    System.out.println("/**************** REGISTRAR PAGO EVENTO ****************/");
                    System.out.println("/*                                               */");
                    System.out.println("/*************************************************/");

                    String idOrdenString;
                    do {
                        System.out.println("Ingrese el código de su orden: ");
                        idOrdenString = sc.nextLine();
                    } while (idOrdenString.matches(".*[a-z].*"));
                    int idOrden = Integer.parseInt(idOrdenString);
                    

                    for (OrdenPago ordenPago : ListaOrdenesPago) {
                        if ((ordenPago.getId() == idOrden) && (ordenPago.getCliente().equals(cliente)) && (ordenPago.getEstadoPago().equals(EstadoPago.PENDIENTEPAGO))) {
                            System.out.println("Su orden con código " + ordenPago.getId() + " está pendiente de pago");
                            System.out.println("¿Desea registrar el pago ahora? (S/N)");
                            String registrarPago = sc.nextLine().toUpperCase();

                            switch (registrarPago) {
                                case "S":
                                    boolean noSalir = true;
                                    String codigoTransaccion;
                                    do {
                                        System.out.println("Ingrese el código de la transacción: ");
                                        codigoTransaccion = sc.nextLine();
                                        if (codigoTransaccion.matches(".*[a-z].*")) {
                                            noSalir = false;
                                        }
                                    } while (noSalir);
                                    ordenPago.setIdTransaccion(Long.parseLong(codigoTransaccion));
                                    ordenPago.setFechaRegistroTransaccion(new Date());
                                    System.out.println("Listo, se ha registrado. Cuando el planificador valide el pago se pondrá en contacto con usted. ");
                                    break;
                                case "N":
                                    System.out.println("Su pago no ha sifo registrado");
                                    break;
                                default:
                                    System.out.println("Ingrese una opción correcta");
                                    break;
                            }
                            

                        } else if ((ordenPago.getId() == idOrden) && (ordenPago.getCliente().equals(cliente)) && (ordenPago.getEstadoPago().equals(EstadoPago.CONFIRMADO))) {
                            System.out.println("Su orden con código " + ordenPago.getId() + " está confirmada");
                        } else {
                            System.out.println("No tiene orden de pago con ese código. ");
                        }
                    }

                    break;
            }

            System.out.println("\n 1. Solicitar planificacion de evento");
            System.out.println(" 2. Registrar pago evento");
            System.out.println(" 3. Salir");

            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

        }

        return true;
    }

    public Boolean validarTiempo(String fechaEvento, int opcion) {
        int diferencia = calcularDiferenciaFechas(fechaEvento, opcion);

        switch (opcion) {
            case 1://Boda
                if (diferencia >= 10) {
                    return true;
                } else {
                    return false;
                }
            case 2://Fiesta Infantil
                if (diferencia > 21) {
                    return true;
                } else {
                    System.out.println(diferencia);
                    return false;
                }
            case 3://Fiesta Empresarial
                if (diferencia > 2) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    @SuppressWarnings("unchecked")
    private int calcularDiferenciaFechas(String fecha, int opcion) {
        try {
            Calendar inicio = new GregorianCalendar();
            Calendar fin = new GregorianCalendar();
            inicio.setTime(new Date());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaEvento = new Date();
            try {
                fechaEvento = dateFormat.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(fecha));
            int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
            int difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
            int difD = (int) ((fechaEvento.getTime() - (new Date()).getTime()) / 86400000);;

            // System.out.println(difD);
            if (opcion == 1) {
                return difM;
            } else if (opcion == 2) {
                return difD;
            } else if (opcion == 3) {
                return difM;
            }

        } catch (ParseException ex) {
        }
        return 0;

    }

}
