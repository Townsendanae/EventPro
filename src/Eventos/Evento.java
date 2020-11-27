
package Eventos;

import Papeleo.EstadoEvento;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.Random;
import java.util.ArrayList;

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
//    TipoEvento tipo;
    ArrayList<Adicional> adicionales;
    
    
    //-----------------------Metodos------------------------------
    
    public void generarCodigo(){//GENERAR CODIGO 4 DIGITOS
        Random ID=new Random();
        this.ID=1000+ID.nextInt(9000);
    }
    
    public String mostrarMensaje(){
        return "mensaje"; //FALTA DETALLES
    }
    
    
}
