/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    //--- Setter
    
    public void setVehiculo(String Vehiculo){
        this.vehiculo = vehiculo;
    }
    
    //---- Getter
    
    public String getVehiculo(){
        return this.vehiculo;
    }
    
    //---- Constructor ----
    
    public Boda(int ID, Cliente cliente, Planificador planificador, ArrayList<Adicional> adicionales, int capacidad, String vehiculo){
        super(ID, cliente, planificador, adicionales, capacidad);
        this.vehiculo = vehiculo;
        this.precio = 3500;
    }
    
    
}
