package Eventos;

/**
 *
 * @author isaac
 */
public class FiestaEmpresarial {

    private boolean transporte;
    private int cantPersonas;
    
    //------------GETERS--------------
    public boolean getTransporte() {
        return transporte;
    }
    public int getCantPersonas() {
        return cantPersonas;
    }
    //--------------SETERS---------------
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }
    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }
    
     public String mostrarMensahe(){
        return "YA VERE QUE SE PONE AQUI X3";
    }

}
