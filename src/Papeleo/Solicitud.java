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
    
    //Constructor
    
    
    
    // Número
    
    public String getNumero(){
        return this.numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;  
    }
    
    // Cliente
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    // Planificador
    
    
    public Planificador getPlanificador(){
        return this.planificador;
    }
    
    public void setPlanificador(Planificador planificador){
        this.planificador = planificador;
    }
    
    // Fecha Solicitud
    
    public Date getFechaSolicitud(){
        return this.fechaSolicitud;
    }
    
    public void setFechaSolicitud(Date fechaSolicitud){
        this.fechaSolicitud = fechaSolicitud;
    }
    
    // Fecha Evento
    
    public Date getFechaEvento(){
        return this.fechaEvento;
    }
    
    public void setFechaEvento(Date fechaEvento){
        this.fechaEvento = fechaEvento;
    }
    
    //ID
    
    public int getiI(){
        return this.id;
    }
    
    // ID no debería poder cambiar. ID único.
    
    // Estado Solicitud
    
    public EstadoSolicitud getEstadoSolicitud(){
        return this.estadoSolicitud;
    }
    
    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud){
        this.estadoSolicitud = estadoSolicitud;
    }
    
    
}
