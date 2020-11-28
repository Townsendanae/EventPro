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
    private long idTransaccion;
    private long codigo; // Generado de forma aleatoria
    private Date fechaRegistro;
    private Cliente cliente;
    private Evento evento;
    private EstadoPago estadoPago;
    private double totalPagar;
    
   //----------Constructor------------
    
    public OrdenPago(Cliente cliente, Evento evento){ 
        this.cliente = cliente;
        this.evento = evento;
        this.estadoPago = EstadoPago.PENDIENTEPAGO;
        this.codigo = obtieneCodigo();
        this.totalPagar = evento.getPrecio();
    }
    
    
    // ---------Setters ---------------
    
    public void setIdTransaccion(long idTransaccion){
        this.idTransaccion = idTransaccion;
    }
    
    public void setIdOrden(long codigo){
        this.codigo = codigo;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void setEvento(Evento evento){
        this.evento = evento;
    }
    
    public void setEstadoPago(EstadoPago estadoPago){
        this.estadoPago = estadoPago;
    }
    
    public void setTotalPagar(double totalPagar){
        this.totalPagar = totalPagar;
    }
    
    // ------- Getters ----------
    
    public long getIdTransaccion(){
        return this.idTransaccion;
    }
    
    public long getIdOrden(){
        return this.codigo;
    }
 
    public Date getFechaRegistro(){
        return this.fechaRegistro;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public Evento getEvento(){
        return this.evento;
    }
    
    public EstadoPago getEstadoPago(){
        return this.estadoPago;
    }
    
    public double getTotalPagar(){
        return this.totalPagar;
    }
      
    
   
    
    // -------------Métodos------------- 
    public void guardarDatosPago(){  
        String info = this.codigo + " " + "codigo_evento con un get" + " " + this.totalPagar + " " +this.estadoPago + " " + this.idTransaccion + " " + this.fechaRegistro;
        ManejoArchivos.EscribirArchivo("ordenPago.txt",info);
    }
    
    public void mostrarMensaje(){
        System.out.println("Código de la orden: "+this.idTransaccion);
    }
    
    //Generar codigo aleatorio
    
    private static int obtieneCodigo() { //Obtener codigo de forma aleatoria
       Random r = new Random();
       return r.nextInt(1000);
    }
    
}
