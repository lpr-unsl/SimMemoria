/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

/**
 *
 * @author dearf
 */
public class Pagina {
    private int idProceso;// si el id=-1, entonces la pagina en realidad es un marco de memoria.
    private int nro;
    private int marcoDonde;
    private int marcoDisp; //0--Marco disponible, 1--Marco no disponible.
    private int memoria;//0 memoria principal, 1 memoria virtual
    
    public Pagina(int nroProceso,int nroPag){
     this.idProceso=nroProceso;
     this.nro=nroPag;
     this.marcoDisp=0;
     this.memoria=1;
    }

    public int getMarcoDonde() {
        return marcoDonde;
    }

    public void setMarcoDonde(int marcoDonde) {
        this.marcoDonde = marcoDonde;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getMarcoDisp() {
        return marcoDisp;
    }

    public void setMarcoDisp(int marcoDisp) {
        this.marcoDisp = marcoDisp;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
    
}
