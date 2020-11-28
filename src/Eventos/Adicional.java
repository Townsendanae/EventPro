/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Papeleo.*;
import java.util.*;

/**
 *
 * @author danae
 */
public class Adicional {

    private TipoAdicional tipo;
    private int cantidad;
    private double precioUnitario; // depende del elemento en particular - constructor. 
    private double total = 0; // precio * cantidad 
    private List<String> bebidas; // EN caso que sea bebida

    Scanner sc = new Scanner(System.in);

    // --- Setters ------
    public void setTipo(TipoAdicional tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //--- Getters ----- 
    public TipoAdicional getTipo() {
        return this.tipo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public double getTotal() {
        return this.total;
    }

    // --- Constructores ------
    public Adicional(int adicional) {

        switch (adicional) {
            case 1:
                this.tipo = TipoAdicional.COMIDA;
                System.out.print("Ingrese la cantidad de platos: ");
                cantidad = sc.nextInt();
                this.precioUnitario = 15;
                break;

            case 2:
                this.tipo = TipoAdicional.BOCADITOS;
                System.out.print("Cantidad de bocaditos: ");
                cantidad = sc.nextInt();
                if (cantidad > 150) {
                    this.precioUnitario = 0.10;
                    break;
                } else {
                    this.precioUnitario = 0.25;
                    break;
                }

            case 3:
                this.tipo = TipoAdicional.MUSICA;
                cantidad = 1;

                System.out.println("Opciones: \n 1. DJ \n 2. Banda");
                System.out.print("Opción a elegir: ");
                int opcion = sc.nextInt();
                if (opcion == 1) {
                    total = 300;
                } else {
                    total = 2000;
                }
                sc.nextLine();
                System.out.println("¿Desea ingresar la otra opción de Música? (S/N): ");
                String agregar = sc.nextLine();

                if (agregar.equals("S") && (total == 300)) {
                    total += 2000;
                } else if (agregar.equals("S") && (total == 2000)) {
                    total += 300;
                }
                break;
                
            case 4:
                this.tipo = TipoAdicional.FOTOGRAFIA;
                this.precioUnitario = 500;
                this.cantidad = 1;
                break;
                
            case 5:
                this.tipo = TipoAdicional.BEBIDA;
                this.bebidas = new ArrayList();
                String salir = null;
                do {
                    int precioBebida = 0;
                    System.out.println("Opciones: \n 1. Whisky \n 2. Vodka \n 3. Cerveza \n 4. Refrescos");
                    System.out.print("Opcion a elegir: ");
                    int eleccion = sc.nextInt();
                    System.out.println("Ingrese la cantidad: ");
                    int cantidadBebida = sc.nextInt();
                    if ((eleccion == 1) && (!bebidas.contains("Whisky"))){
                        precioBebida = 50;
                        this.total += precioBebida * cantidadBebida;
                        bebidas.add("Whisky");
                    } else if ((eleccion == 2) && (!bebidas.contains("Vodka"))) {
                        precioBebida = 25;
                        this.total += precioBebida * cantidadBebida;
                        bebidas.add("Vodka");
                        } else if ((eleccion == 3) && (!bebidas.contains("Cerveza"))) {
                        precioBebida = 3;
                        this.total += precioBebida * cantidadBebida;
                        bebidas.add("Cerveza");
                    } else if ((eleccion == 4) && (!bebidas.contains("Refrescos"))){
                        precioBebida = 1;
                        this.total += precioBebida * cantidadBebida;
                        bebidas.add("Refrescos");
                    }
                    else 
                        System.out.println("Ya ha elegido esa opción o ha ingresado un número no valido");
                    sc.nextLine();
                    System.out.println("¿Desea ingresar más opciones de Bebida? (S/N): ");
                    salir = sc.nextLine();
                } while (salir.equals("S"));

        }
    }

}
