package Eventos;

import Papeleo.*;
import Papeleo.TipoEvento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.*;

/**
 *
 * @author isaac
 */
public class Evento {

    int capacidad;
    double precio;
    int ID;
    Cliente cliente;
    Planificador planificador;
    EstadoEvento estado;
    TipoEvento tipo;
    ArrayList<Adicional> adicionales;

    Scanner sc = new Scanner(System.in);

    //-----------------------Metodos------------------------------
    public int generarCodigo() {//GENERAR CODIGO 4 DIGITOS
        Random ID = new Random();
        this.ID = 1000 + ID.nextInt(9000);
        return this.ID;
    }

    public void generarPago() {//PAGA BASE DEL EVENTO
        if (tipo.equals("Boda")) {
            precio = 3500;
        } else if (tipo.equals("FiestaInfantil")) {
            precio = 300;
        } else {
            precio = 2000;
        }

    }

    public String mostrarMensaje() {
        return "mensaje"; //FALTA DETALLES
    }

    public void guardarAdicional(int numero) {
        String eleccion;
        switch (numero) {
            case 1:
                System.out.print("Ingrese la cantidad de platos: ");
                int cantidad = sc.nextInt();
                double total = cantidad * 15;
                System.out.print("Total: " + total + "\n ¿Agregar?(S/N): ");
                eleccion = sc.nextLine();
                sc.nextLine();
                if (eleccion.equals("S")) //Invoca constructor adicional para COMIDA              
                    adicionales.add(new Adicional(TipoAdicional.COMIDA, total, cantidad, 15));                                  
                break;

            case 2:
                System.out.print("Cantidad de bocaditos: ");
                cantidad = sc.nextInt();
                if (cantidad > 150) {
                    total = 0.10 * cantidad;
                    System.out.println("Total: " + total + "\n ¿Agregar?(S/N): ");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para BOCADITOS
                        adicionales.add(new Adicional(TipoAdicional.BOCADITOS, total, cantidad, 0.10));
                    break;
                    
                } else {
                    total = 0.25 * cantidad;
                    System.out.println("Total: " + total + "\n ¿Agregar?(S/N): ");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para BOCADITOS
                        adicionales.add(new Adicional(TipoAdicional.BOCADITOS, total, cantidad, 0.25));
                    break;                    
                }

            case 3:
                System.out.println("Opciones: \n 1. DJ ($300) \n 2. Banda($200)");
                System.out.print("¿Qué prefiere?");
                int opcion = sc.nextInt();
                if (opcion == 1) {
                    total = 300;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                        adicionales.add(new Adicional(TipoAdicional.MUSICA, 300));
                        break;
                    
                } else {
                    total = 2000;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) //Invocar constructor adicional para MUSICA
                        adicionales.add(new Adicional(TipoAdicional.MUSICA, 2000));
                        break;                  
                }

            case 4: // 
                total = 500;
                System.out.println("Total: " + total + " \n Agregar(S/N)");
                eleccion = sc.nextLine();
                sc.nextLine();
                if (eleccion.equals("S")) //Invocar constructor adicional para FOTOGRAFÍA
                    adicionales.add(new Adicional(TipoAdicional.FOTOGRAFIA, 500));
                break;

            case 5:               
                System.out.println("Opciones: \n 1. Whisky \n 2. Vodka \n 3. Cerveza \n 4. Refrescos");
                System.out.print("Opcion a elegir: ");
                opcion = sc.nextInt();
                System.out.println("Ingrese la cantidad: ");
                cantidad = sc.nextInt();
                if (opcion == 1) {
                    total = 50 * cantidad;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) {
                        adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 50));
                    }
                    //Invocar constructor adicional para BEBIDA
                } else if (opcion == 2) {
                    total = 25 * cantidad;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) {
                        adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 25));
                    }
                    //Invocar constructor adicional para BEBIDA                       

                } else if (opcion == 3) {
                    total = 3 * cantidad;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) {
                        adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 3));
                    }
                    //Invocar constructor adicional para BEBIDA

                } else if (opcion == 4) {
                    total = cantidad;
                    System.out.println("Total: " + total + " \n Agregar(S/N)");
                    eleccion = sc.nextLine();
                    sc.nextLine();
                    if (eleccion.equals("S")) {
                        adicionales.add(new Adicional(TipoAdicional.BEBIDA, total, cantidad, 1));
                    }
                    //Invocar constructor adicional para BEBIDA

                }

        }
    }

}
