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
    /**
     * Constructor de Usuario
     * @param nombre
     * @param apellido
     * @param usuario
     * @param contrasena
     * @param tipo 
     */
    public Usuario(String nombre, String apellido, String usuario, String contrasena, char tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }
    
    
    /**
     * Obtiene el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el apellido del Usuario 
     * 
     * @return 
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Modifica el dato del apellido del usuario 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Obtiene el ussuario 
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Modifica el Usuario 
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Obtiene la contraseña
     * @return 
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Coloca la contraseña para el usuario 
     * @param contrasena 
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    /**
     * Obtiene el tipo adicional 
     * @return 
     */
    public char getTipo() {
        return tipo;
    }
    /**
     * 
     * @param tipo 
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<OrdenPago> getListaOrdenesPago(){
        return this.ListaOrdenesPago;
    }
    /**
     * 
     * @param ordenPago 
     */
    public void setListaSolicitud(OrdenPago ordenPago) {
        ListaOrdenesPago.add(ordenPago);
    }
    
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", contrasena=" + contrasena + ", tipo=" + tipo + '}';
    }
    /**
     * Valida la fecha dada para cada condicion segun el evento
     * @return 
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
