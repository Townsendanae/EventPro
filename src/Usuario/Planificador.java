/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Papeleo.Solicitud;
import java.util.*;


/**
 *
 * @author ablup
 */
public class Planificador extends Usuario {

    //ArrayList<Evento> ListaEventos = new ArrayList<Evento>();
    ArrayList<Solicitud> ListaSolicitud = new ArrayList<Solicitud>();

    //---- Constructor ----
    public Planificador(String nombre, String apellido, String usuario, String contrasena, char tipo, ArrayList<Solicitud> listaSolicitud) {
        super(nombre, apellido, usuario, contrasena, tipo);
        this.ListaSolicitud = listaSolicitud;
    }

    public Planificador(String nombre, String apellido, String usuario, String contrasena, char tipo) {
        super(nombre, apellido, usuario, contrasena, tipo);
    }

    public void nenuPlanificador() {

    }

    
}
