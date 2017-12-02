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
    private int PCpag; //Ejecucion secuencia:_nro de pagina a la que le toca ejecutarse.
    private int PCpointer;//apuntador al elemento del arreglo de sec                   
    private boolean secuencial;
    private int[] pcPag_arreglo;//arreglo que tiene la secuencia de ejecucion en caso de elegir ejecucion personalizada
   
    
    public Proceso(int id, int nroPag){
        this.estado=0; //DEPENDE
        this.PCpag=0;
        this.id=id;
        this.nroPag=nroPag;
        this.pagRam=0;
        this.pagVir=nroPag;
        this.secuencial=true;
        this.paginas=new Pagina[nroPag];
        this.inicializarPaginas();
        
    };
    
    public Proceso(int id,int nroPag, int[] PCpag){
        this.estado=0; //DEPENDE
        this.id=id;
        this.nroPag=nroPag;
        this.pagRam=0;
        this.pagVir=nroPag;
        this.secuencial=false;
        this.paginas=new Pagina[nroPag];
        this.pcPag_arreglo=new int[nroPag];
        this.pcPag_arreglo=PCpag;
        this.PCpointer=0;
        this.PCpag=pcPag_arreglo[PCpointer];
        this.secuencial=false;
        this.inicializarPaginas();
    }
    
    private void inicializarPaginas()
    
    {
       int i=0;
       while (i<this.nroPag)
       {
         this.paginas[i]=new Pagina(this.id,i);
         this.paginas[i].setMemoria(1);//al crear una pagina por defecto esta en memoria virtual.
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

    public int getPCpag() {
        
        return PCpag;
    }

    public void setPCpag(int PC) {
    
        this.PCpag = PC;
        
      
    }
    
    
    
    public void actualizarPCpag(){
     if (this.secuencial==true){    
        if (this.PCpag<this.nroPag){
            this.PCpag++;
        }
        if (this.PCpag==this.nroPag){
            this.PCpag=-1;//Quiere decir q ya todas las paginas fueron ejecutadas 
        }
        
    }
  
    else{
          
            this.PCpointer++;
            if(this.PCpointer<this.pcPag_arreglo.length){
            this.PCpag=this.pcPag_arreglo[PCpointer];
            }
        
        if (this.PCpointer==this.pcPag_arreglo.length){
            this.PCpag=-1;//Quiere decir q ya todas las paginas fueron ejecutadas 
        }

    }
}

    public boolean isSecuencial() {
        return secuencial;
    }
    
    
}