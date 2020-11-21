/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleo;
import java.util.*;
import Usuario.*;
import trabajoconarchivos.*;
/**
 *
 * @author danae
 */
public class OrdenPago {
    private long idTransaccion;
    private long codigo; // Generado de forma aleatoria
    private Date fechaRegistro;
    private Cliente cliente;
    //private Evento evento;
    private EstadoPago estadoPago;
    private double totalPagar;
    
   //Constructor
    
    public OrdenPago(Cliente cliente){ //Falta evento
        this.cliente = cliente;
        this.estadoPago = EstadoPago.PENDIENTEPAGO;
        this.codigo = obtieneCodigo();
        //el total a pagar con el objeto evento
    }
    
    //ID Transacción
    
    public long getIdTransaccion(){
        return this.idTransaccion;
    }
    
    public void setIdTransaccion(long idTransaccion){
        this.idTransaccion = idTransaccion;
    }
    
    // ID orden
    
    public long getIdOrden(){
        return this.codigo;
    }
    
    public void setIdOrden(long codigo){
        this.codigo = codigo;
    }
    
    //Fecha Registro
    
    public Date getFechaRegistro(){
        return this.fechaRegistro;
    }
    
    //la fecha de registro no se deberá modificar. 
    
    //Cliente
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    //Evento
    
    //public Evento getEvento(){
    //    return this.evento;
    //}
    
    //public void setEvento(Evento evento){
    //    this.evento = evento;
    //}
    
    // Estado Pago
    
    public EstadoPago getEstadoPago(){
        return this.estadoPago;
    }
    
    public void setEstadoPago(EstadoPago estadoPago){
        this.estadoPago = estadoPago;
    }
    
    //Total Pagar 
    
    public double getTotalPagar(){
        return this.totalPagar;
    }
    
    public void setTotalPagar(double totalPagar){
        this.totalPagar = totalPagar;
    }
    
   
    
    // Métodos: 
    public void guardarDatosPago(){  
        String info = this.codigo + " " + "codigo_evento con un get" + " " + this.totalPagar + " " +this.estadoPago + " " + this.idTransaccion + " " + this.fechaRegistro;
        ManejoArchivos.EscribirArchivo("ordenPago.txt",info);
    }
    
    public void mostrarMensaje(){
        System.out.println("Código de la orden: "+this.idTransaccion);
    }
    
    //Generar codigo aleatorio
    
    private static int obtieneCodigo() {
       Random r = new Random();
       return r.nextInt(1000);
    }
    
}
