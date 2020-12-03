/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleo;

import java.util.*;
import Usuario.*;
import trabajoconarchivos.*;
import Eventos.*;

/**
 *
 * @author danae
 */
public class OrdenPago {

    private static ArrayList<Integer> codigos = new ArrayList();// Variable stática para ver si los códigos no se repiten. 
    private long idTransaccion;
    private int codigo; // Generado de forma aleatoria
    private Date fechaRegistro;
    private Date fechaEvento;
    private Cliente cliente;
    private Evento evento;
    private EstadoPago estadoPago;
    private double totalPagar;
    private ArrayList<Adicional> adicionales = new ArrayList();

    //----------Constructor------------
    public OrdenPago(Cliente cliente, Evento evento,Date fechaEvento, ArrayList<Adicional> adicionales, double totalPagar) {
        this.cliente = cliente;
        this.evento = evento;
        this.fechaEvento = fechaEvento;
        this.fechaRegistro = new Date();
        this.estadoPago = EstadoPago.PENDIENTEPAGO;
        this.totalPagar = evento.getPrecio();
        this.adicionales = adicionales;
        
        boolean salir = true;
        do {
            int numero = obtieneCodigo();// genera numero
            if (!codigos.contains(numero)) { // Si el codigo no está en codigos, se sale del while y se agrega a la lista. 
                this.codigo = numero;
                codigos.add(codigo);
                salir = false;
            }
        } while (salir);

    }

    // ---------Setters ---------------
    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public void setIdOrden(int codigo) {
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    // ------- Getters ----------
    public long getIdTransaccion() {
        return this.idTransaccion;
    }

    public long getIdOrden() {
        return this.codigo;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public EstadoPago getEstadoPago() {
        return this.estadoPago;
    }

    public double getTotalPagar() {
        return this.totalPagar;
    }

    // -------------Métodos------------- 
    public void mostrarDatosPago() {
        System.out.println("CÓDIGO PAGO: "+this.codigo);
        System.out.println("FECHA   : "+this.fechaRegistro);
        System.out.println("CLIENTE: "+this.cliente);
        System.out.println("EVENTO: "+this.evento);
        System.out.println("FECHA EVENTO: "+this.evento.getFechaEvento());
        
        System.out.println("ADICIONALES: ");
        for (Adicional adicional:adicionales){
            System.out.println(adicional);            
        }
        
        System.out.println("TOTAL A PAGAR: "+this.evento.getPrecio());
        
        
        String info = this.codigo + " " + "codigo_evento con un get" + " " + this.totalPagar + " " + this.estadoPago + " " + this.idTransaccion + " " + this.fechaRegistro;
        //ManejoArchivos.EscribirArchivo("ordenPago.txt",info);
    }

    public void mostrarMensaje() {
        System.out.println("Código de la orden: " + this.idTransaccion);
    }

    //Generar codigo aleatorio
    private static int obtieneCodigo() { //Obtener codigo de forma aleatoria
        Random r = new Random();
        return r.nextInt(1000);
    }

}
