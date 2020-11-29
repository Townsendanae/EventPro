package Eventos;

import Papeleo.EstadoEvento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class FiestaEmpresarial extends Evento{

    private boolean transporte;
    private int cantPersonas;
    
    //------------GETERS--------------
    public boolean getTransporte() {
        return transporte;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    //--------------SETERS---------------
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
  
     //------- Constructores --------
     
     public FiestaEmpresarial(int ID, Cliente cliente, Planificador planificador, ArrayList<Adicional> adicionales, int capacidad, boolean transporte, int cantPersonas){
        super(ID, cliente, planificador, adicionales, capacidad);
        this.transporte = transporte;
        this.cantPersonas = cantPersonas;
        this.precio = 2000;
    }
     //-----Metodos------------
     public String mostrarMensaje(){//IMPRESION
        return "--------Registro de Datos del Evento-------------------"+"\nHora inicio: "+this.horaInicio+"\nHora final: "+this.horaFin+"\nCapacidad: "+this.cantPersonas+"\n¿Desea registrar elementos adicionales?(S/N)";
    }
     
     

}
