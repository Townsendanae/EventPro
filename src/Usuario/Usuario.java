/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Eventos.Evento;
import Papeleo.OrdenPago;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

/**
 *
 * @author Gustavo
 */
public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String usuario;
    protected String contrasena;
    protected char tipo;
    protected static ArrayList<OrdenPago> ListaOrdenesPago = new ArrayList<OrdenPago>();

    public Usuario(String nombre, String apellido, String usuario, String contrasena, char tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
    public ArrayList<OrdenPago> getListaOrdenesPago(){
        return this.ListaOrdenesPago;
    }
    
    public void setListaSolicitud(OrdenPago ordenPago) {
        ListaOrdenesPago.add(ordenPago);
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrasena=" + contrasena + ", tipo=" + tipo + '}';
    }
    /**
    * Metodo para validar fecha que no sobrepase el tiempo
    * segun el evento
    *
    */
    public Date validarFecha() {
        
        Calendar c = Calendar.getInstance();
        Date hoy = new Date();
        Scanner sc = new Scanner(System.in);
        System.out.println("Fecha del evento:  "); // USUARIO INGRESA FECHA DEL EVENTO
        String fecha = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); // El formato.
        Date convertedDate = new Date(); // Se crea el objeto al que se le va a designar la hora del usuario. 

        try {
            convertedDate = dateFormat.parse(fecha); // se convierte String a Date
        } catch (ParseException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
        // -----------No sé como comparar las fechas :( ------
        //System.out.println(hoy);
        //System.out.println(convertedDate);
        
        //c.add(Calendar.MONTH, 10);
        //System.out.println(hoy.compareTo(convertedDate));

        return convertedDate; // --------- Hasta que funcione el método que retorne esto. -----
    }
    
    
    
   
}
