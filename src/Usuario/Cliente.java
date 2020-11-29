/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.*;
import eventproaplicacion.*;
import Papeleo.*;

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
    public void menuCliente(Cliente cliente, ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n 1. Solicitar planificacion de evento");
        System.out.println(" 2. Registrar pago evento");
        System.out.println(" 3. Salir");

        System.out.println("Ingrese una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1: // SOLICITAR PLANIFICACION EVENTO
                System.out.println("/**************** NUEVA SOLICITUD ****************/");
                System.out.println("/*                                               */");
                System.out.println("/*************************************************/");
                System.out.println("Bienvenido, " + cliente.getNombre());
                System.out.println("TIPO DE EVENTO (Elija) ");
                System.out.println("\n 1. Boda");
                System.out.println(" 2. Fiesta Infantil");
                System.out.println(" 3. Fiesta Empresarial");

                System.out.println("Seleccione: ");
                int seleccion = sc.nextInt();
                //sc.nextLine();
                
                Date fechaEvento;
                switch (seleccion) {                 
                    case 1: // BODA
                        fechaEvento = cliente.validarFecha();
                        // crear solicitud 
                        Solicitud solicitud = new Solicitud(cliente,new Date(), fechaEvento, usuarios);
                        
                        
                        break;
                    case 2: // FIESTA INTANTIL
                        fechaEvento = cliente.validarFecha();
                        
                        break;
                    case 3: // FIESTA EMPRESARIAL
                        fechaEvento = cliente.validarFecha();
                        
                        break;
                        
                }

                break;

            case 2: // REGISTRAR PAGO EVENTO
                System.out.println("/**************** REGISTRAR PAGO EVENTO ****************/");
                System.out.println("/*                                               */");
                System.out.println("/*************************************************/");

                break;
            case 3: // SALIR 
                break;

        }

    }
    
}
