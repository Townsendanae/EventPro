
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
    public Boda(Cliente cliente, Planificador planificador, Date fecha, String horaInicio, String horaFin, int capacidad,Solicitud solicitud, String vehiculo){
        super(cliente, planificador, fecha, horaInicio, horaFin, capacidad, solicitud);
        this.vehiculo = vehiculo;
        this.precio = 3500;
    }
    
    //--- Setter---------------
    public void setVehiculo(String Vehiculo){
        this.vehiculo = vehiculo;
    }
    
    //---- Getter-------------
    public String getVehiculo(){
        return this.vehiculo;
    }
    
  
    //----Metodos-------------------------
    public String mostrarMensaje(){//IMPRESION
        return "--------Registro de Datos del Evento-------------------"+"\nHora inicio: "+this.horaInicio+"\nHora final: "+this.horaFin+"\nVehículo: "+this.vehiculo+"\n¿Desea registrar elementos adicionales?(S/N)";
    }
    
}
