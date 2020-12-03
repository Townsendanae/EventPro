package Eventos;

import Papeleo.*;
//import Papeleo.TipoEvento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.*;

/**
 *
 * @author isaac
 */
public class Evento {

    protected int capacidad;
    protected double precio;
    protected int ID;
    protected Cliente cliente;
    protected Planificador planificador;
    protected EstadoEvento estado = EstadoEvento.PENDIENTE;
    protected String horaInicio;
    protected String horaFin;
    protected Solicitud solicitud;
    protected Date fechaEvento;
    // TipoEvento tipo;
    protected ArrayList<Adicional> adicionales = new ArrayList();
    protected ArrayList<Double> sumaAdicionales = new ArrayList();//La suma de la cuenta de los pedidos adicionales

    Scanner sc = new Scanner(System.in);//Scanner

    //----------------Setters -----------
    //--------------Getters ----------------
    public double getPrecio() {
        return this.precio;
    }
    
    public Date getFechaEvento(){
        return this.fechaEvento;
    }

    //-----------------------Metodos------------------------------
    public int generarCodigo() {//GENERAR CODIGO 4 DIGITOS
        Random ID = new Random();
        this.ID = 1000 + ID.nextInt(9000);
        return this.ID;
    }

    public void guardarAdicional(int numero) {

        String eleccion;
        switch (numero) {
            case 1://Pedido platos
                System.out.print("Ingrese la cantidad de platos: ");
                int cantidad = sc.nextInt();
                sc.nextLine();
                double total = cantidad * 15;
                System.out.print("Total: " + total + "\n ¿Agregar?(S/N): ");
                eleccion = sc.nextLine();
                if (eleccion.equals("S")) //Invoca constructor adicional para COMIDA              
                {
                    adicionales.add(new Adicional(TipoAdicional.COMIDA, total, cantidad, 15));
                    precio += total;
                    sumaAdicionales.add(total);
                }
                break;

            case 2://Pedido Bocaditos
                System.out.print("Cantidad de bocaditos: ");
                cantidad = sc.nextInt();
                sc.nextLine();
                if (cantidad > 150) {
                    total = 0.10 * cantidad;
                    System.out.println("Total: " + total + "\n ¿Agregar?(S/N): ");
                    eleccion = sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para BOCADITOS
                    {
                        adicionales.add(new Adicional(TipoAdicional.BOCADITOS, total, cantidad, 0.10));
                        precio += total;
                        sumaAdicionales.add(total);
                    }
                    break;

                } else {
                    total = 0.25 * cantidad;
                    System.out.println("Total: " + total + "\n ¿Agregar?(S/N): ");
                    eleccion = sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para BOCADITOS
                    {
                        adicionales.add(new Adicional(TipoAdicional.BOCADITOS, total, cantidad, 0.25));
                        precio += total;
                    }
                    break;
                }

            case 3://Pedido Musica
                System.out.println("Opciones: \n 1. DJ ($300) \n 2. Banda($2000)");
                System.out.print("¿Qué prefiere?");
                int opcion = sc.nextInt();
                sc.nextLine();
                if (opcion == 1) {
                    total = 300;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                    {
                        adicionales.add(new Adicional(TipoAdicional.MUSICA, 300));
                        precio += total;
                        sumaAdicionales.add(total);
                    }
                    break;

                } else {
                    total = 2000;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                    {
                        adicionales.add(new Adicional(TipoAdicional.MUSICA, 2000));
                        precio += total;
                        sumaAdicionales.add(total);

                    }
                    break;
                }

            case 4: // Pedido Fotografia
                total = 500;
                System.out.println("Total: " + total + " \n Agregar(S/N)");
                eleccion = sc.nextLine();
                if (eleccion.equals("S")) //Invocar constructor adicional para FOTOGRAFÍA
                {
                    adicionales.add(new Adicional(TipoAdicional.FOTOGRAFIA, 500));
                    precio += total;
                    sumaAdicionales.add(total);
                }
                break;

            case 5:
                System.out.println("Opciones: \n 1. Whisky \n 2. Vodka \n 3. Cerveza \n 4. Refrescos");
                System.out.print("Opcion a elegir: ");
                opcion = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese la cantidad: ");
                cantidad = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        total = 50 * cantidad;
                        System.out.println("Total: " + total + " \n Agregar(S/N)");
                        eleccion = sc.nextLine();
                        if (eleccion.equals("S")) {
                            adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 50));
                            precio += total;
                            sumaAdicionales.add(total);
                        }
                        //Invocar constructor adicional para BEBIDA
                        break;
                    case 2:
                        total = 25 * cantidad;
                        System.out.println("Total: " + total + " \n Agregar(S/N)");
                        eleccion = sc.nextLine();
                        if (eleccion.equals("S")) {
                            adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 25));
                            precio += total;
                            sumaAdicionales.add(total);
                        }
                        //Invocar constructor adicional para BEBIDA                       
                        break;
                    case 3:
                        total = 3 * cantidad;
                        System.out.println("Total: " + total + " \n Agregar(S/N)");
                        eleccion = sc.nextLine();
                        ;
                        if (eleccion.equals("S")) {
                            adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 3));
                            precio += total;
                            sumaAdicionales.add(total);
                        }
                        //Invocar constructor adicional para BEBIDA
                        break;
                    case 4:
                        total = cantidad;
                        System.out.println("Total: " + total + " \n Agregar(S/N)");
                        eleccion = sc.nextLine();
                        if (eleccion.equals("S")) {
                            adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 1));
                            precio += total;
                            sumaAdicionales.add(total);
                        }
                        //Invocar constructor adicional para BEBIDA
                        break;
                    default:
                        break;
                }

        }
    }

    public String mostrarMensaje() {
        return "mensaje"; //FALTA DETALLES
    }

    public double generarPago(ArrayList<Double> sumaAdicionales) {//Se va sumando el costo de los adicionales
        double suma = 0;
        for (Double x : sumaAdicionales) {
            suma += x;
        }
        return suma;
    }

    public void generarPago(String eleccionPago, ArrayList<Solicitud> solicitudes) {
        for (Solicitud solicitud : solicitudes) {
            if (this.solicitud == solicitud) {
                solicitud.setEstadoSolicitud(EstadoSolicitud.APROBADO);
            }
        }
            
        System.out.println("/********************* ORDEN DE PAGO  *******************/");
        System.out.println("/*                                                      */");
        System.out.println("/********************************************************/\n");
        
        OrdenPago ordenPago = new OrdenPago(cliente, this, fechaEvento, adicionales, precio);
        ordenPago.mostrarDatosPago();

    }

    public int mostrarMenuAdicional() {
        System.out.println("/*---------------------------------------------------/*" + "\nLas opciones son:\n1.  Comida" + "\n2.  Bocaditos" + "\n3.  Música" + "\n4.  Fotografía" + "\n5.  Bebida" + "\n6.  Regresar al menú anterior");
        System.out.println("Elija elemento a adicionar: ");
        int eleccion = sc.nextInt();
        sc.nextLine();

        return eleccion;

    }

    //------Contructores ------
    public Evento(Cliente cliente, Planificador planificador, Date fecha, String horaInicio, String horaFin, int capacidad, Solicitud solicitud) {
        //this.ID = ID; Se genera de forma automática
        this.cliente = cliente;
        this.planificador = planificador;
        this.capacidad = capacidad;
        this.solicitud = solicitud;
        this.fechaEvento = fechaEvento;
    }
}
