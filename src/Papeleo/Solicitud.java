/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleo;
import Usuario.*;
import java.text.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author danae
 */
public class Solicitud {
    private static int contador;
    private int numero;
    private Cliente cliente;
    private Planificador planificador;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private int id;
    private EstadoSolicitud estadoSolicitud;
    private String tipoEvento;
    
 //---- Setters ------
    public void setNumero(int numero){
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
    
    public int getNumero(){
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
    
    
    public int getId(){
        return this.id;
    }
    
    // ID no debería poder cambiar. ID único.
    
    public EstadoSolicitud getEstadoSolicitud(){
        return this.estadoSolicitud;
    }
    
    
    // ---- Constructores ---- 
    
//    public Solicitud(String numero, Cliente cliente, Planificador planificador, Date fechaSolicitud, Date fechaEvento, int id){
//        this.cliente = cliente;
//        this.numero = numero;
//        this.fechaEvento = fechaEvento;
//        this.fechaSolicitud = fechaSolicitud;
//        this.id = id;
//        this.planificador = planificador;
//        this.estadoSolicitud = EstadoSolicitud.PENDIENTE;
//    }
    
    public Solicitud(Cliente cliente,Date fechaSolicitud, String fechaEvento, ArrayList<Usuario> usuarios, String tipoEvento){
        this.cliente = cliente;
        this.numero += this.contador +1 ;
        this.contador += 1;
        this.fechaSolicitud = fechaSolicitud;
        this.planificador = planificador;
        this.planificador = AsignarPlanificador(usuarios);
        this.estadoSolicitud = EstadoSolicitud.PENDIENTE;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date fecha = new Date();
        try {
            fecha = dateFormat.parse(fechaEvento);
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.fechaEvento = fecha;
        
        
        
    }
    
    public Planificador AsignarPlanificador(ArrayList<Usuario> usuarios){
        // Crear array Planificadores
        ArrayList <Planificador> planificadores = new ArrayList();
        for (Usuario usuario: usuarios){
            if(usuario.getTipo() == 'P')
                planificadores.add((Planificador)usuario);                     
        }              
        // Generar valor aleatorio entre 0 y longitud de la Arraylist Planificador
        int tamano = planificadores.size();
        Random r = new Random();
        int aleatorio = r.nextInt(tamano);
        Planificador planificador = planificadores.get(aleatorio);
               
        return planificador;        
    }
    
    
    public String toString(){
        return this.id+" - "+this.fechaEvento;
    }
    
}
    
