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
    private static long contador = 100000;
    private int numero;
    private Cliente cliente;
    private Planificador planificador;
    private Date fechaSolicitud;
    private Date fechaEvento;
    private int id;
    private EstadoSolicitud estadoSolicitud;
    private TipoEvento tipoEvento;
    private double precioBase;
    
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
    
    
    public EstadoSolicitud getEstadoSolicitud(){
        return this.estadoSolicitud;
    }
    
    public TipoEvento getTipoEvento(){
        return this.tipoEvento;
    }
    
    
    // ---- Constructores ---- 
       
    public Solicitud(Cliente cliente,Date fechaSolicitud, String fechaEvento, ArrayList<Usuario> usuarios, TipoEvento tipoEvento,double precioBase){
        this.cliente = cliente;
        this.id += this.contador +1 ;
        this.contador += 1;
        this.fechaSolicitud = fechaSolicitud;      
        this.planificador = AsignarPlanificador(usuarios);
        this.estadoSolicitud = EstadoSolicitud.PENDIENTE;
        this.precioBase = precioBase;
        this.tipoEvento = tipoEvento;
        
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
        int aleatorio = r.nextInt(tamano-1);
        Planificador planificadorSelec = planificadores.get(aleatorio);
               
        return planificadorSelec;        
    }
    
 
    
    @Override
    public String toString(){
        System.out.println("DATOS:");
        System.out.println("CLIENTE: "+cliente.getNombre()+" "+cliente.getApellido());
        System.out.println("PLANIFICADOR ASIGNADO: "+planificador.getNombre()+" "+planificador.getApellido());
        System.out.println("FECHA DE REGISTRO: "+fechaSolicitud);
        System.out.println("TIPO EVENTO: "+tipoEvento);
        System.out.println("FECHA DEL EVENTO: "+new SimpleDateFormat("dd/MM/yyyy").format(fechaEvento));
        System.out.println("PRECIO BASE: "+precioBase);
        
        return "";
    
    }
    
}
    
