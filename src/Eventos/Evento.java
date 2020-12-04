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
    protected EstadoEvento estado;
    protected String horaInicio; 
    protected String horaFin;
    protected Date fechaEvento;
   // TipoEvento tipo;
    protected ArrayList<Adicional> adicionales;
    protected ArrayList<Double> sumaAdicionales;//La suma de la cuenta de los pedidos adicionales

    Scanner sc = new Scanner(System.in);//Scanner
    
    //Constructor
    public Evento(Cliente cliente, Planificador planificador, Date fecha, String horaInicio, String horaFin, int capacidad){ 
        this.ID = generarCodigo(); 
        this.cliente = cliente;
        this.estado = EstadoEvento.PENDIENTE; 
        this.planificador = planificador;
        this.capacidad = capacidad;
        this.fechaEvento=fecha;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
        this.capacidad=capacidad;
    }
    //----------------Setters -----------
    
    
    //--------------Getters ----------------
    
    public double getPrecio(){
        return this.precio;
    }

    //-----------------------Metodos------------------------------
    public int generarCodigo() {//GENERAR CODIGO 4 DIGITOS
        Random ID = new Random();
        this.ID = 1000 + ID.nextInt(9000);
        return this.ID;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getID() {
        return ID;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Planificador getPlanificador() {
        return planificador;
    }

    public EstadoEvento getEstado() {
        return estado;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }
    
    /*Metodo por el cual almacenamos los adicionales para cada evento*/
    public void guardarAdicional(int numero) {
        String eleccion=null;
        do{
            switch (numero) {
                case 1://Pedido platos
                    System.out.print("Ingrese la cantidad de platos: ");
                    int cantidad = sc.nextInt();
                    double total = cantidad * 15;
                    System.out.print("Total: " + total + "\n ¿Agregar?(S/N): ");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) //Invoca constructor adicional para COMIDA              
                    {
                        adicionales.add(new Adicional(TipoAdicional.COMIDA, total, cantidad, 15));
                        sumaAdicionales.add(total);
                    }
                    break;

                case 2://Pedido Bocaditos
                    System.out.print("Cantidad de bocaditos: ");
                    cantidad = sc.nextInt();
                    if (cantidad > 150) {
                        total = 0.10 * cantidad;
                        System.out.println("Total: " + total + "\n ¿Agregar?(S/N): ");
                        eleccion = sc.nextLine();
                        sc.nextLine();
                        if (eleccion.equals("S")) //Invocar constructor adicional para BOCADITOS
                        {
                            adicionales.add(new Adicional(TipoAdicional.BOCADITOS, total, cantidad, 0.10));
                            sumaAdicionales.add(total);
                        }
                        break;

                    } else {
                        total = 0.25 * cantidad;
                        System.out.println("Total: " + total + "\n ¿Agregar?(S/N): ");
                        eleccion = sc.nextLine();
                        sc.nextLine();
                        if (eleccion.equals("S")) //Invocar constructor adicional para BOCADITOS
                        {
                            adicionales.add(new Adicional(TipoAdicional.BOCADITOS, total, cantidad, 0.25));
                            sumaAdicionales.add(total);
                        }
                        break;
                    }

                case 3://Pedido Musica
                    System.out.println("Opciones: \n 1. DJ ($300) \n 2. Banda($2000)");
                    System.out.print("¿Qué prefiere?");
                    int opcion = sc.nextInt();
                    if (opcion == 1) {
                        total = 300;
                        System.out.println("Total: " + total + " \n Agregar(S/N)");
                        eleccion = sc.nextLine();
                        sc.nextLine();
                        if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                        {
                            adicionales.add(new Adicional(TipoAdicional.MUSICA, 300));
                            sumaAdicionales.add(total);
                        }
                        break;

                    } else {
                        total = 2000;
                        System.out.println("Total: " + total + " \n Agregar(S/N)");
                        eleccion = sc.nextLine();
                        sc.nextLine();
                        if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                        {
                            adicionales.add(new Adicional(TipoAdicional.MUSICA, 2000));
                            sumaAdicionales.add(total);

                        }
                        break;
                    }

                case 4: // Pedido Fotografia
                    total = 500;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para FOTOGRAFÍA
                    {
                        adicionales.add(new Adicional(TipoAdicional.FOTOGRAFIA, 500));
                        sumaAdicionales.add(total);
                    }
                    break;

                case 5:
                    System.out.println("Opciones: \n 1. Whisky \n 2. Vodka \n 3. Cerveza \n 4. Refrescos");
                    System.out.print("Opcion a elegir: ");
                    opcion = sc.nextInt();
                    System.out.println("Ingrese la cantidad: ");
                    cantidad = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            total = 50 * cantidad;
                            System.out.println("Total: " + total + " \n Agregar(S/N)");
                            eleccion = sc.nextLine();
                            sc.nextLine();
                            if (eleccion.equals("S")) {
                                adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 50));
                                sumaAdicionales.add(total);
                            }
                            //Invocar constructor adicional para BEBIDA
                            break;
                        case 2:
                            total = 25 * cantidad;
                            System.out.println("Total: " + total + " \n Agregar(S/N)");
                            eleccion = sc.nextLine();
                            sc.nextLine();
                            if (eleccion.equals("S")) {
                                adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 25));
                                sumaAdicionales.add(total);
                            }
                            //Invocar constructor adicional para BEBIDA                       
                            break;
                        case 3:
                            total = 3 * cantidad;
                            System.out.println("Total: " + total + " \n Agregar(S/N)");
                            eleccion = sc.nextLine();
                            sc.nextLine();
                            if (eleccion.equals("S")) {
                                adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 3));
                                sumaAdicionales.add(total);
                            }
                            //Invocar constructor adicional para BEBIDA
                            break;
                        case 4:
                            total = cantidad;
                            System.out.println("Total: " + total + " \n Agregar(S/N)");
                            eleccion = sc.nextLine();
                            sc.nextLine();
                            if (eleccion.equals("S")) {
                                adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 1));
                                sumaAdicionales.add(total);
                            }
                            //Invocar constructor adicional para BEBIDA
                            break;
                        
                        default:
                            break;
                    }

            }
           
            
        }while(eleccion.equals("S"));
    }
    
    
    public String mostrarMensaje() {
        return "mensaje"; //FALTA DETALLES
    }
    public double generarPago(ArrayList<Double> sumaAdicionales){//Se va sumando el costo de los adicionales
        double suma=0;
        for (Double x:sumaAdicionales){
            suma+=x;
        }
        return suma;
    }
    
    
    public static void menu(){//SE MUESTRA EL MENÚ
        System.out.println("/*****REGISTRO DE ELEMENTOS ADICIONALES PARA EL MENU******/");
        System.out.println("/*---------------------------------------------------/*"+"\nLas opciones son:\n1.  Comida"+"\n2.  Bocaditos"+"\n3.  Música"+"\n4.  Fotografía"+"\n5.  Bebida"+"\n6.  Regresar al menú anterior");
        System.out.println("Elija elemento a adicionar: ");
    }
    
    
    //------Contructores ------
    
    
    
    public static void crearEvento(Evento evento){
        
        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("evento.txt", true);
            bw = new BufferedWriter(fichero);
            
                        
            int mes=0;
            if (evento.getFechaEvento().getMonth()>0 && evento.getFechaEvento().getMonth()<=11)
                mes=evento.getFechaEvento().getMonth()+1;
            else if(evento.getFechaEvento().getMonth()==0)
                mes=12;
            
            String fechaEvento = evento.getFechaEvento().getDate()+"/"+mes+"/"+
                    (evento.getFechaEvento().getYear()+1900);
            String tipoEvento=null;
            if(evento instanceof Boda){
                tipoEvento="Boda";
            }else if (evento instanceof FiestaInfantil){
                tipoEvento="Fiesta Infantil";
            }else if(evento instanceof FiestaEmpresarial){
                tipoEvento="Fiesta Empresarial";
            }
            
            String[] datos = {String.valueOf(evento.getID()), evento.getCliente().getNombre(),
                tipoEvento,fechaEvento,evento.getHoraInicio(),evento.getHoraFin(),String.valueOf(evento.getCapacidad()),
                evento.getPlanificador().getNombre(),evento.getEstado().toString()};
            
            
            String linea="\n"+datos[0];

            for (int i = 1; i < datos.length; i++) {
                
                linea += ","+datos[i];
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
}
