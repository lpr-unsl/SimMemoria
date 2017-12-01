/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;


public class Proceso {
    
    private int id;
    private int estado;//0--nuevo,1--listo,2--listo supendido,3--ejecutando,4--terminado
    private int nroPag;// nro de paginas en total
    private int pagRam; //nro de paginas en memoria ram
    private int pagVir; //nro de paginas en memoria virtual
    private Pagina[] paginas;
    private int PC; //nro de pagina a la que le toca ejecutarse.
    
    public Proceso(int id, int nroPag){
        this.estado=0; //DEPENDE
        this.id=id;
        this.nroPag=nroPag;
        this.pagRam=0;
        this.pagVir=nroPag;
        this.paginas=new Pagina[nroPag];
        this.inicializarPaginas();
    };
    
    private void inicializarPaginas()
    
    {
       int i=0;
       while (i<this.nroPag)
       {
         this.paginas[i]=new Pagina(this.id,i);
         this.paginas[i].setMemoria(1);
         i++;
       } 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNroPag() {
        return nroPag;
    }

    public void setNroPag(int nroPag) {
        this.nroPag = nroPag;
    }

    public int getPagRam() {
        return pagRam;
    }

    public void setPagRam(int pagRam) {
        this.pagRam = pagRam;
    }

    public int getPagVir() {
        return pagVir;
    }

    public void setPagVir(int pagVir) {
        this.pagVir = pagVir;
    }

    public Pagina getPagina(int i) {
        return paginas[i];
    }

    public void setPaginas(int i, Pagina p) {
        int ki=i;
        this.paginas[ki] = p;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }
    
    
}
