/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

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
    Scanner sc = new Scanner(System.in);

    public Cliente(String nombre, String apellido, String usuario, String contrasena, char tipo, String celular, String correo) {
        super(nombre, apellido, usuario, contrasena, tipo);
        this.celular = celular;
        this.correo = correo;

    }

    public String getCelular() {
        return celular;
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

        System.out.println("Ingrese una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();
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

                    System.out.println("Seleccione: ");
                    int seleccion = sc.nextInt();
                    sc.nextLine();

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

                            Solicitud solicitud_B=new Solicitud(cliente, new Date(), fechaEvento, usuarios, TipoEvento.BODA, 3500); // SE CREA LA SOLICITUD
                            
                            Planificador planificador = solicitud_B.AsignarPlanificador(usuarios);
                            for (Usuario usuario : usuarios) {
                                if (usuario == planificador) {
                                    planificador.setListaSolicitud(solicitud_B);
                                }
                            }
                            System.out.println("Ha registrado todos los datos necesarios para la solicitud");
                            System.out.println("Desea registrar su solicitud:(S/N) ");
                            
                            op=sc.nextLine();
                            if(op.charAt(0)=='S')
                                Solicitud.crearSolicitud(solicitud_B);
                            break;

                        case 2: // FIESTA INTANTIL
                            
                            while (!cliente.validarTiempo(fechaEvento, seleccion)) {
                                System.out.println("\n** La fecha es muy próxima. Para este tipo de evento debemos tener por lo menos 3 semanas para planificar. Ingrese nuevamente \n");
                                System.out.println("Ingresa fecha Evento: Ingrese formato dia/mes/año");
                                fechaEvento = sc.nextLine();
                            }
                            System.out.println("¡Fecha Válida!");
                            Solicitud solicitud_fe = new Solicitud(cliente, new Date(), fechaEvento, usuarios, TipoEvento.FIESTAINFANTIL,300); // SE CREA LA SOLICITUDlicitud solicitud_FI = new Solicitud(cliente, new Date(), fechaEvento, usuarios, "Fiesta Infantil"); // SE CREA LA SOLICITUD
                            Planificador planificador_FI = solicitud_fe.AsignarPlanificador(usuarios);
                            for (Usuario usuario : usuarios) {
                                if (usuario == planificador_FI) {
                                    planificador_FI.setListaSolicitud(solicitud_fe);
                                }
                            }
                            System.out.println("Ha registrado todos los datos necesarios para la solicitud");
                            
                            System.out.println("Desea registrar su solicitud:(S/N) ");
                            
                            op=sc.nextLine();
                            if(op.charAt(0)=='S')
                                Solicitud.crearSolicitud(solicitud_fe);
                            
                            break;

                        case 3: // FIESTA EMPRESARIAL
                            while (!cliente.validarTiempo(fechaEvento, seleccion)) {
                                System.out.println("\n**La fecha es muy próxima. Para este tipo de evento debemos tener por lo menos 2 meses para planificar. Ingrese nuevamente. \n");
                                System.out.println("Ingresa fecha Evento: Ingrese formato dia/mes/año");
                                fechaEvento = sc.nextLine();
                            }
                            System.out.println("¡Fecha Válida!");
                            Solicitud solicitud_fem = new Solicitud(cliente, new Date(), fechaEvento, usuarios, TipoEvento.FIESTAEMPRESARIAL,2000); // SE CREA LA SOLICITUD
                            Planificador planificador_FE = solicitud_fem.AsignarPlanificador(usuarios);
                            for (Usuario usuario : usuarios) {
                                if (usuario == planificador_FE) {
                                    planificador_FE.setListaSolicitud(solicitud_fem);
                                }
                            }
                            System.out.println("Ha registrado todos los datos necesarios para la solicitud");
                            System.out.println("Desea registrar su solicitud:(S/N) ");
                           
                            op=sc.nextLine();
                            if(op.charAt(0)=='S')
                                Solicitud.crearSolicitud(solicitud_fem);
                            
                            break;
                    }
                    System.out.println(Planificador.getListaSolicitud());
                    break;

                case 2: // REGISTRAR PAGO EVENTO
                    System.out.println("/**************** REGISTRAR PAGO EVENTO ****************/");
                    System.out.println("/*                                               */");
                    System.out.println("/*************************************************/");

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
    
