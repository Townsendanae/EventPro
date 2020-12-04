package Eventos;

import Papeleo.EstadoEvento;
import Papeleo.Solicitud;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author isaac
 */
public class FiestaEmpresarial extends Evento {

    private boolean transporte = false;
    private int capacidad;

    //------------GETERS--------------
    public boolean getTransporte() {
        return transporte;
    }

    public int getCantPersonas() {
        return capacidad;
    }

    //--------------SETERS---------------
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public void setCantPersonas(int cantPersonas) {
        this.capacidad = cantPersonas;
    }

    //------- Constructores --------
    public FiestaEmpresarial(Cliente cliente, Planificador planificador, Date fecha, String horaInicio, String horaFin, int capacidad, Solicitud solicitud, String transporte) {
        super(cliente, planificador, fecha, horaInicio, horaFin, capacidad, solicitud);
        this.capacidad = capacidad;
        this.precio = 2000;

        if (transporte.charAt(0) == 'S') {
            this.transporte = true;
        }
    }
    //-----Metodos------------

    @Override
    public String mostrarMensaje() {//IMPRESION
        return "Si ustede realiza su evento con el mismo planificador"
                + " Su vehiculo sera totalmente gratuito";
    }

}
