package Eventos;

import Papeleo.*;
//import Papeleo.TipoEvento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
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
    protected int horaInicio;
    protected int horaFin;
    protected Solicitud solicitud;
    protected Date fechaEvento;
    protected int idOrdenPago;
    // TipoEvento tipo;
    protected ArrayList<Adicional> adicionales = new ArrayList();
    protected ArrayList<Double> sumaAdicionales = new ArrayList();//La suma de la cuenta de los pedidos adicionales

    Scanner sc = new Scanner(System.in);//Scanner

    //Constructor
    
    /**
    * Constructor Evento con todos sus atributos inicializados
    */
    public Evento(Cliente cliente, Planificador planificador, Date fecha, int horaInicio, int horaFin, int capacidad, Solicitud solicitud) {
        this.ID = generarCodigo();
        this.cliente = cliente;
        this.planificador = planificador;
        this.capacidad = capacidad;
        this.solicitud = solicitud;
        this.fechaEvento = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    

    /**Setters necesarios**/
    public void setIdOrdenPago(int idOrdenPago) {
        this.idOrdenPago = idOrdenPago;
    }

    /**Getters necesarios**/
    public double getPrecio() {
        return this.precio;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Date getFechaEvento() {
        return this.fechaEvento;
    }

    public int getID() {
        return this.ID;
    }

    public ArrayList<Adicional> getArrayAdicionales() {
        return this.adicionales;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public int getIdOrdenPago() {
        return this.idOrdenPago;
    }

    //-----------------------Metodos------------------------------
    /**
    * Metodo para Generar Codigo de 4 digitos 
    * Para el ID del Evento
    */
    public int generarCodigo() {//GENERAR CODIGO 4 DIGITOS
        Random ID = new Random();
        int id = 1000 + ID.nextInt(9000);
        return id;
    }

    /**
    * Metodo por el cual almacenamos los adicionales para cada evento
    */
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
                    System.out.println("Se ha agregado el adicional correctamente");
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
                        System.out.println("Se ha agregado el adicional correctamente");
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
                        sumaAdicionales.add(total);
                        System.out.println("Se ha agregado el adicional correctamente");
                    }
                    break;
                }

            case 3://Pedido Musica
                System.out.println("Opciones: \n 1. DJ ($300) \n 2. Banda($2000)");
                System.out.print("¿Qué prefiere? ");
                int opcion = sc.nextInt();
                sc.nextLine();

                /* COMPROBAR QUE EL USUARIO NO HAYA ELEGIDO LA OPCIÓN ANTES. */
                boolean opcionDj = true;
                boolean opcionBanda = true;

                for (Adicional adicional : adicionales) {
                    if ((adicional.getTipo().equals(TipoAdicional.MUSICA)) && (adicional.getTotal() == 300)) {
                        opcionDj = false;
                    } else if ((adicional.getTipo().equals(TipoAdicional.MUSICA)) && (adicional.getTotal() == 2000)) {
                        opcionBanda = false;
                    }
                }
                /* --- */

                if ((opcion == 1) && (opcionDj)) {
                    total = 300;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                    {
                        adicionales.add(new Adicional(TipoAdicional.MUSICA, 300));
                        precio += total;
                        sumaAdicionales.add(total);
                        System.out.println("Se ha agregado el adicional correctamente");
                    }
                    break;

                } else if ((opcion == 2) && (opcionBanda)) {
                    total = 2000;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                    {
                        adicionales.add(new Adicional(TipoAdicional.MUSICA, 2000));
                        precio += total;
                        sumaAdicionales.add(total);
                        System.out.println("Se ha agregado el adicional correctamente");

                    }
                    break;
                } else {
                    System.out.println("YA HA AGREGADO ESTE ELEMENTO A SU LISTA, ELIJA OTRO.");
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
                    System.out.println("Se ha agregado el adicional correctamente");
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
                            System.out.println("Se ha agregado el adicional correctamente");
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
                            System.out.println("Se ha agregado el adicional correctamente");
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
                            System.out.println("Se ha agregado el adicional correctamente");
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
                            System.out.println("Se ha agregado el adicional correctamente");
                        }                     
                        break;                        
                    default:
                        System.out.println("Elija una opción válida");
                        break;
                }
                break;
            default:
                System.out.println("Ingrese una opción válida");
                break;

        }
    }
    /**
    * Metodo para mostrar un mensaje en la clase Evento
    * es sobrescrito en las clases hijas
    */
    public String mostrarMensaje() {
        return ""; 
    }
    
    /**
    * Metodo para generar pago con los respectivos valores de los adicionales
    */
//    public double generarPago(ArrayList<Double> sumaAdicionales) {//Se va sumando el costo de los adicionales
//        double suma = 0;
//        for (Double x : sumaAdicionales) {
//            suma += x;
//        }
//        return suma;
//    }
    
    /**
    * Sobrecarga del mismo metodo para generar pago de las solicitudes
    */
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
    
    
    /**
    * Metodo que nos muestra todos los adicionales a elegir y devuelve la eleeción
    */
    public int mostrarMenuAdicional() {
        System.out.println("/*---------------------------------------------------/*" + "\nLas opciones son:\n1.  Comida" + "\n2.  Bocaditos" + "\n3.  Música" + "\n4.  Fotografía" + "\n5.  Bebida" + "\n6.  Regresar al menú anterior");
        System.out.println("Elija elemento a adicionar: ");
         String eleccionStr;
        do {
            System.out.println("Ingrese una opcion: ");
            eleccionStr = sc.nextLine();
        } while (eleccionStr.matches(".*[a-z].*"));
        int eleccion = Integer.parseInt(eleccionStr);
        return eleccion;

    }
    
    /**
    * Metodo que por medio del manejo de archivo
    * guardamos los eventos
    */
    public static void crearEvento(Evento evento) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("evento.txt", true);
            bw = new BufferedWriter(fichero);

            int mes = 0;
            if (evento.getFechaEvento().getMonth() > 0 && evento.getFechaEvento().getMonth() <= 11) {
                mes = evento.getFechaEvento().getMonth() + 1;
            } else if (evento.getFechaEvento().getMonth() == 0) {
                mes = 12;
            }

            String fechaEvento = evento.getFechaEvento().getDate() + "/" + mes + "/"
                    + (evento.getFechaEvento().getYear() + 1900);
            String tipoEvento = null;
            if (evento instanceof Boda) {
                tipoEvento = "Boda";
            } else if (evento instanceof FiestaInfantil) {
                tipoEvento = "Fiesta Infantil";
            } else if (evento instanceof FiestaEmpresarial) {
                tipoEvento = "Fiesta Empresarial";
            }

            String[] datos = {String.valueOf(evento.getID()), evento.getCliente().getNombre(),
                tipoEvento, fechaEvento, String.valueOf(evento.getHoraInicio()), String.valueOf(evento.getHoraFin()), String.valueOf(evento.getCapacidad()),
                evento.getPlanificador().getNombre(), evento.getEstado().toString()};

            String linea = "\n" + datos[0];

            for (int i = 1; i < datos.length; i++) {

                linea += "," + datos[i];
            }
            System.out.println(linea);
            bw.write(linea);

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
    
    /**
    * Con este metodo creamos el archivo con los adicionales
    */

    public static void crearAdicional(Evento evento) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("adicional.txt", true);
            bw = new BufferedWriter(fichero);

            for (Adicional a : evento.adicionales) {
                String[] datos = {String.valueOf(evento.getID()), a.getTipo().toString(),
                    String.valueOf(a.getCantidad()), String.valueOf(a.getPrecioUnitario()), String.valueOf(a.getTotal())};

                String linea = "\n" + datos[0];

                for (int i = 1; i < datos.length; i++) {

                    linea += "," + datos[i];
                }
                System.out.println(linea);
                bw.write(linea);
            }

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
    
    /**
    * Con este metodo guardamos los adicionales en una lista
    */
    public void mostrarMenuGuardarAdicional(Evento evento) {
        boolean Nosalir = true;

        while (Nosalir) {

            System.out.println("/*-------------------------------------------------------------*/");
            System.out.println("¿Desea agregar elementos adicionales? (S/N)");
            String agregarAdicional = sc.nextLine().toUpperCase();

            if (agregarAdicional.equals("S")) {
                int eleccion = 0;
                do {// Mostrar Menú adicional: 
                    eleccion = evento.mostrarMenuAdicional();
                    evento.guardarAdicional(eleccion);
                } while (eleccion != 6);// AGREGAR ADICIONALES PARA FI     
                Nosalir = false;
            } else if (agregarAdicional.equals("N")) {
                System.out.println("No se han agregado elementos adicionales");
                Nosalir = false;
            } else {
                System.out.println("Ingrese una opción válida.");
            }
        }

    }

}
