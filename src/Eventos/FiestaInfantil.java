/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Papeleo.EstadoEvento;
import Papeleo.Solicitud;
import Usuario.Cliente;
import Usuario.Planificador;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danae
 */
public class FiestaInfantil extends Evento {

    private int personajesDis;
    private int sorpresas;
    private boolean juegosFiesta;

    //--- Setters ----
    public void setPersonajesDis(int personajesDis) {
        this.personajesDis = personajesDis;
    }

    public void setSorpresas(int sorpresas) {
        this.sorpresas = sorpresas;
    }

    public void setJuegosFiesta(boolean juegosFiesta) {
        this.juegosFiesta = juegosFiesta;
    }

    //------- Getters -------
    public int getPersonajesDis() {
        return this.personajesDis;
    }

    public int getSorpresas() {
        return this.sorpresas;
    }

    public boolean getJuegosFiesta() {
        return this.juegosFiesta;
    }

    //--- Constructores-----
    public FiestaInfantil(Cliente cliente, Planificador planificador, Date fecha, String horaInicio, String horaFin, int capacidad, Solicitud solicitud, int personajesDis, int sorpresas, String juegosFiesta) {
        super(cliente, planificador, fecha, horaInicio, horaFin, capacidad, solicitud);
        this.precio = 300;
        this.personajesDis = personajesDis;
        this.sorpresas = sorpresas;
        if (juegosFiesta.equals("S")) {
            this.juegosFiesta = true;
        }
        else
            this.juegosFiesta = false;

    }
    //-----metodos-----------------

    public String mostrarMensaje() {//IMPRESION
        return "--------Registro de Datos del Evento-------------------" + "\nHora inicio: " + this.horaInicio + "\nHora final: " + this.horaFin + "\nPersonajes Disfrazados: " + this.personajesDis + "\n¿Desea registrar elementos adicionales?(S/N)";
    }
}
