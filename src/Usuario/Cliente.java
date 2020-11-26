/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.Scanner;

/**
 *
 * @author ablup
 */
public class Cliente extends Usuario{
    private String celular;
    private String correo;
    
    public Cliente(String nombre, String apellido, String usuario, String contrasena, char tipo, String celular,String correo) {
        super(nombre, apellido, usuario, contrasena, tipo);
        this.celular=celular;
        this.correo=correo;                
        
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "celular=" + celular + ", correo=" + correo + '}';
    }
    
   //public Solicitud registrarSolicitud(){}
    //public void registrarPago(){}
    public void menuCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("++++++++++++++++MENU CLIENTE++++++++++++");
        System.out.println("1.- Solicitar planificacion de evento");
        System.out.println("2.- Registrar pago envento");
        System.out.println("3.- Salir");
        
    }
    
}
