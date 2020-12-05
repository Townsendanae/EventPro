
package Eventos;
import Usuario.*;
import Papeleo.*;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danae
 */
public class Boda extends Evento{
    private String vehiculo; 
    
    //---- Constructor ------------
   
    /**
     * Contructors de Boda con todos sus respectivos parametros
     * @param cliente
     * @param planificador
     * @param fecha
     * @param horaInicio
     * @param horaFin
     * @param capacidad
     * @param solicitud
     * @param vehiculo
     * 
     */
    public Boda(Cliente cliente, Planificador planificador, Date fecha, int horaInicio, int horaFin, int capacidad,Solicitud solicitud, String vehiculo){
        super(cliente, planificador, fecha, horaInicio, horaFin, capacidad, solicitud);
        this.vehiculo = vehiculo;
        this.precio = 3500;
    }
    
    //--- Setter---------------
    /**
     * Metodo para colocar el vehiculo
     * @param vehiculo
     * 
     */
    public void setVehiculo(String Vehiculo){
        this.vehiculo = vehiculo;
    }
    
    //---- Getter-------------
    /**
     * Metodo para obtener el parametro vehiculo
     * @return vehiculo
     */
    public String getVehiculo(){
        return this.vehiculo;
    }
    
  
    //----Metodos-------------------------
    /**
     * Metodo sobreescrito para mostrar
     * @return Mensaje para boda
     */
    public String mostrarMensaje(){//IMPRESION
        return "Recuerde que los novios tendran un 15% de descuento "
                + "si compran sus tickets de luna de miel en la "
                + "aerolinea LATAM";
    }
    
}
