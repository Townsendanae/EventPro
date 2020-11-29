
package Eventos;
import Usuario.*;
import Papeleo.*;

import java.util.ArrayList;

/**
 *
 * @author danae
 */
public class Boda extends Evento{
    private String vehiculo; 
    
    //---- Constructor ------------
    public Boda(int ID, Cliente cliente, Planificador planificador, ArrayList<Adicional> adicionales, int capacidad, String vehiculo){
        super(ID, cliente, planificador, adicionales, capacidad);
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
