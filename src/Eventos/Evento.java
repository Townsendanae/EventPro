
package Eventos;

import Papeleo.EstadoEvento;
import Papeleo.TipoEvento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.Random;
import java.util.ArrayList;
import Papeleo.TipoEvento;

/**
 *
 * @author isaac
 */
public class Evento {
    int capacidad;
    double precio;
    int ID;
    Cliente cliente;
    Planificador planificador;
    EstadoEvento estado;
    TipoEvento tipo;
    ArrayList<Adicional> adicionales;
    
    
    //-----------------------Metodos------------------------------
    
    public int generarCodigo(){//GENERAR CODIGO 4 DIGITOS
        Random ID=new Random();
        this.ID=1000+ID.nextInt(9000);
        return this.ID;
    }
    
    public void generarPago(){//PAGA BASE DEL EVENTO
        if (tipo.equals("Boda")){
            precio=3500;
        }else if(tipo.equals("FiestaInfantil")){
            precio=300;
        }else {
            precio=2000;
        }
            
        
    }
    
    public String mostrarMensaje(){
        return "mensaje"; //FALTA DETALLES
    }
    
    
}
