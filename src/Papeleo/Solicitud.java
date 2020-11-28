/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleo;
import Usuario.*;
import java.util.*;
/**
 *
 * @author danae
 */
public class Solicitud {
    private String numero;
    private Cliente cliente;
    private Planificador planificador;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private int id;
    private EstadoSolicitud estadoSolicitud;
    
 //---- Setters ------
    public void setNumero(String numero){
        this.numero = numero;  
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void setPlanificador(Planificador planificador){
        this.planificador = planificador;
    }
    
    public void setFechaSolicitud(Date fechaSolicitud){
        this.fechaSolicitud = fechaSolicitud;
    }
    
    public void setFechaEvento(Date fechaEvento){
        this.fechaEvento = fechaEvento;
    }
    
     public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud){
        this.estadoSolicitud = estadoSolicitud;
    }
     
    //----- Getters -----
    
    public String getNumero(){
        return this.numero;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public Planificador getPlanificador(){
        return this.planificador;
    }
    
    public Date getFechaSolicitud(){
        return this.fechaSolicitud;
    }

    
    public Date getFechaEvento(){
        return this.fechaEvento;
    }
    
    
    public int getiI(){
        return this.id;
    }
    
    // ID no debería poder cambiar. ID único.
    
    public EstadoSolicitud getEstadoSolicitud(){
        return this.estadoSolicitud;
    }
    
    
    // ---- Constructores ---- 
    
    public Solicitud(String numero, Cliente cliente, Planificador planificador, Date fechaSolicitud, Date fechaEvento, int id){
        this.cliente = cliente;
        this.numero = numero;
        this.fechaEvento = fechaEvento;
        this.fechaSolicitud = fechaSolicitud;
        this.id = id;
        this.planificador = planificador;
        this.estadoSolicitud = EstadoSolicitud.PENDIENTE;
    }
}
    
