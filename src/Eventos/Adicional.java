/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import Papeleo.*;
import java.util.*;

/**
 *
 * @author danae
 */
public class Adicional {

    private TipoAdicional tipo;
    private int cantidad;
    private double precioUnitario; // depende del elemento en particular - constructor. 
    private double total; // precio * cantidad 

    Scanner sc = new Scanner(System.in);

    // --- Setters ------
    public void setTipo(TipoAdicional tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //--- Getters ----- 
    public TipoAdicional getTipo() {
        return this.tipo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public double getTotal() {
        return this.total;
    }

    //--- Constructores -----
    public Adicional(TipoAdicional tipo, double total, int cantidad, double precioUnitario) {
        this.tipo = tipo;
        this.total = total;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Adicional(TipoAdicional tipo, double total) {
        this.tipo = tipo;
        this.total = total;
        this.cantidad = 1;
        this.precioUnitario = total;
    }

 

}
