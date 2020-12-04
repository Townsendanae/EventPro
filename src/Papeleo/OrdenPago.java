/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papeleo;

import java.util.*;
import Usuario.*;
import trabajoconarchivos.*;
import Eventos.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author danae
 */
public class OrdenPago {

    private static ArrayList<Integer> codigos = new ArrayList();// Variable stática para ver si los códigos no se repiten. 
    private long idTransaccion =00;
    private int codigo; // Generado de forma aleatoria
    private Date fechaRegistro;
    private Date fechaEvento;
    private Date fechaRegistroTransaccion;
    private Cliente cliente;
    private Evento evento;
    private EstadoPago estadoPago = EstadoPago.PENDIENTEPAGO;
    private double totalPagar;
    private ArrayList<Adicional> adicionales = new ArrayList();

    //----------Constructor------------
    public OrdenPago(Cliente cliente, Evento evento, Date fechaEvento, ArrayList<Adicional> adicionales, double totalPagar) {
        this.cliente = cliente;
        this.evento = evento;
        this.fechaEvento = fechaEvento;
        this.fechaRegistro = new Date();
        this.totalPagar = evento.getPrecio();
        this.adicionales = adicionales;

        boolean salir = true;
        do {
            int numero = obtieneCodigo();// genera numero
            if (!codigos.contains(numero)) { // Si el codigo no está en codigos, se sale del while y se agrega a la lista. 
                this.codigo = numero;
                codigos.add(codigo);
                salir = false;
            }
        } while (salir);

    }

    // ---------Setters ---------------
    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public void setIdOrden(int codigo) {
        this.codigo = codigo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    public void setFechaRegistroTransaccion(Date fechaRegistro){
        this.fechaRegistro = fechaRegistro;
    }

    // ------- Getters ----------
    public long getIdTransaccion() {
        return this.idTransaccion;
    }

    public int getId() {
        return this.codigo;
    }

    public Date getFechaRegistroTransaccion() {
        return this.fechaRegistro;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public EstadoPago getEstadoPago() {
        return this.estadoPago;
    }

    public double getTotalPagar() {
        return this.totalPagar;
    }

    // -------------Métodos------------- 
    public void mostrarDatosPago() {
        System.out.println("CÓDIGO PAGO: " + this.codigo);
        System.out.println("FECHA   : " + this.fechaRegistro);
        System.out.println("CLIENTE: " + this.cliente.getNombre() + " " + this.cliente.getApellido());
        System.out.println("EVENTO: " + this.evento.getClass());
        System.out.println("FECHA EVENTO: " + this.evento.getFechaEvento());

        System.out.println("ADICIONALES: ");
        for (Adicional adicional : adicionales) {
            System.out.println(adicional.getTipo());
        }

        System.out.println("TOTAL A PAGAR: " + this.evento.getPrecio());

        //String info = this.codigo + " " + "codigo_evento con un get" + " " + this.totalPagar + " " + this.estadoPago + " " + this.idTransaccion + " " + this.fechaRegistro;
        //ManejoArchivos.EscribirArchivo("ordenPago.txt",info);
    }

//    public void mostrarMensaje() {
//        System.out.println("Código de la orden: " + this.idTransaccion);
//    }
    //Generar codigo aleatorio
    private static int obtieneCodigo() { //Obtener codigo de forma aleatoria
        Random r = new Random();
        return r.nextInt(1000);
    }

    public void guardarOrdenPago() {

        ((Usuario) this.cliente).setListaSolicitud(this);
        
        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
       
        try {
            fichero = new FileWriter("ordenPago.txt", true);
            bw = new BufferedWriter(fichero);

            
            int mes = 0;
            if (this.fechaRegistro.getMonth() > 0 && this.fechaRegistro.getMonth() <= 11) {
                mes = this.fechaRegistro.getMonth() + 1;
            } else if (this.fechaRegistro.getMonth() == 0) {
                mes = 12;
            }
            String fechaRegistro = this.fechaRegistro.getDate() + "/"
                    + mes + "/" + (this.fechaRegistro.getYear() + 1900);
            
            String[] datos = {String.valueOf(this.codigo), String.valueOf(this.evento.getID()),
                String.valueOf(totalPagar),this.estadoPago.toString(),
            String.valueOf(this.idTransaccion),fechaRegistro};
            
            String linea="\n"+datos[0];
            
            for (int i = 1; i < datos.length; i++) {
                
                linea += ","+datos[i];
            }
           

            System.out.println(linea);
            bw.write(linea);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

}
