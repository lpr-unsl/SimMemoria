/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import java.util.ArrayList;
//El algoritmo de reemplazo de paginas es el de reloj.
/**
 *
 * @author dearf
 */
public class Manejador {
    
    private int nroMarcos;
    private int[] bitDeUso;
    private int   bitPointer;//apuntador que se mueve como una aguja de reloj
    private int nroMarcosDisponibles;
    private Pagina[] marcos; //arreglo de marcos de pagina
    private ArrayList<Proceso> procesos;
    private Pagina pagEjecutandose;//pagina que esta en el procesador
    private int PC; //id del proceso al que le toca ejecutarse
    private int PC2;
    private Interfaz I;
    private int nroProcesos;

    public Manejador(int nroMarcos,Interfaz I){
      this.nroMarcos=nroMarcos;
      this.nroMarcosDisponibles=nroMarcos;
      this.marcos=new Pagina[nroMarcos];
      this.bitDeUso=new int[nroMarcos];
      this.nroProcesos=0;
      this.PC=0;
      this.procesos=new ArrayList<>();
      this.I=I;
      this.inicializarMarcos();
      this.bitPointer=0;
      this.inicializarBitsDeUso();
    }
   
    private void inicializarBitsDeUso(){
        
        int i=0;
        while(i<this.bitDeUso.length){
            this.bitDeUso[i]=0;
            i++;
        }
    
    }
    private void inicializarMarcos(){
    
        int i=0;
        while (i<nroMarcos){
        
            marcos[i]=new Pagina(-1,i);
            i++;
        }
    
    }
    
    private void actualizarPC(){
       if(this.PC<this.procesos.size()){
          this.PC++;
       }
       if (this.PC==this.procesos.size()){
          
           this.PC=this.PC2;
          
       }
    }
    
    private void actualizarBitPointer(){
         
          if(this.bitPointer<this.bitDeUso.length){
          this.bitPointer++;
             }
       if (this.bitPointer==this.bitDeUso.length){
          this.bitPointer=0; 
       }
    
    }
    
    public void crearProceso(int cuantasPag){
        Proceso p;  
        p=new Proceso(procesos.size(),cuantasPag);
        procesos.add(p);
        this.nroProcesos++;
        int x=procesos.size()-1;
        this.I.textarea15.setText("Se ha creado el proceso "+x);
        
        if(this.nroMarcosDisponibles>0){//Si hay espacio en memoria
           this.procesos.get(this.procesos.size()-1).getPagina(0).setMemoria(0);
           this.procesos.get(this.procesos.size()-1).setEstado(1);
           this.procesos.get(this.procesos.size()-1).setPagRam(this.procesos.get(this.procesos.size()-1).getPagRam()+1);
           this.procesos.get(this.procesos.size()-1).setPagVir(this.procesos.get(this.procesos.size()-1).getNroPag()-1); 
           //Buscar un marco disponible, y colocar la pagina
           int i=0;
           int d;
           boolean encontrado=false;
           while((i<nroMarcos)&&(encontrado==false)){
                 d=this.marcos[i].getMarcoDisp();
                 if (d==0){//El marco i esta disponible
                     this.marcos[i]=this.procesos.get(this.procesos.size()-1).getPagina(0);
                     this.procesos.get(this.procesos.size()-1).getPagina(0).setMarcoDonde(i);
                     this.marcos[i].setMarcoDisp(1);
                     encontrado=true;
                     this.nroMarcosDisponibles=this.nroMarcosDisponibles-1;
                 }
                 i++;
           }
           }
        else{//Sino hay espacio en memoria
        //skip
        }
        
        System.out.println(procesos.size());
    }
     public void crearProceso_NoSecuencial(int cuantasPag,int[] pcPag){
        int ii=0;
        while(ii<pcPag.length){
        System.out.println("i:_"+pcPag[ii]);
        ii++;
        }
        Proceso p;  
        p=new Proceso(procesos.size(),cuantasPag,pcPag);
        procesos.add(p);
        this.nroProcesos++;
        int x=procesos.size()-1;
        this.I.textarea15.setText("Se ha creado el proceso "+x);
        
        if(this.nroMarcosDisponibles>0){//Si hay espacio en memoria
           this.procesos.get(this.procesos.size()-1).getPagina((this.procesos.get(this.procesos.size()-1).getPCpag())).setMemoria(0);

           this.procesos.get(this.procesos.size()-1).setEstado(1);
           this.procesos.get(this.procesos.size()-1).setPagRam(this.procesos.get(this.procesos.size()-1).getPagRam()+1);
           this.procesos.get(this.procesos.size()-1).setPagVir(this.procesos.get(this.procesos.size()-1).getNroPag()-1); 
           //Buscar un marco disponible, y colocar la pagina
           int i=0;
           int d;
           boolean encontrado=false;
           while((i<nroMarcos)&&(encontrado==false)){
                 d=this.marcos[i].getMarcoDisp();
                 if (d==0){//El marco i esta disponible
                     this.marcos[i]=this.procesos.get(this.procesos.size()-1).getPagina((this.procesos.get(this.procesos.size()-1).getPCpag()));
                     this.procesos.get(this.procesos.size()-1).getPagina((this.procesos.get(this.procesos.size()-1).getPCpag())).setMarcoDonde(i);
                     this.marcos[i].setMarcoDisp(1);
                     encontrado=true;
                     this.nroMarcosDisponibles=this.nroMarcosDisponibles-1;
                 }
                 i++;
           }
           }
        else{//Sino hay espacio en memoria
        //skip
        }
        
        System.out.println(procesos.size());
    }
    public int getNroProcesos() {
        return nroProcesos;
    }
    
    public void ImprimirProcesos(){
        
        if (this.nroProcesos==0){
            
            //skip
        }
        else{
        int i=0;
        while(i<this.procesos.size())
         {
          this.I.ids[i].setText(Integer.toString(this.procesos.get(i).getId()));
          this.I.totalpgs[i].setText(Integer.toString(this.procesos.get(i).getNroPag()));
          this.I.totalrams[i].setText(Integer.toString(this.procesos.get(i).getPagRam()));
          this.I.nrodiscos[i].setText(Integer.toString(this.procesos.get(i).getPagVir()));
          int n=this.procesos.get(i).getEstado();
          if (n==0)
          {    
          this.I.estados[i].setText("Nuevo");
          }
          if (n==1)
          {
          this.I.estados[i].setText("Listo");    
          }
          if (n==2)
          {
          this.I.estados[i].setText("Listo Suspendido");    
          }
          if (n==3)
          {
          this.I.estados[i].setText("Ejecutando");
          }
          if (n==4)
          {
          this.I.estados[i].setText("Terminado");
          }
          i++;
        }
    //textarea10 lista de procesos, columna ID
    //textarea11 lista de procesos columna paginas totales
    //textarea12 lista de procesos columna paginas en memoria
    //textarea13 lista de procesos columna paginas en memoria virtual
    //textarea14 lista de procesos columna estado.
                }
    }
    
    public void ImprimirMemVirtual(){
        int k=0;//indicador de fila de la tabla de memoria virtual
        if (this.nroProcesos==0){
            
            //skip
        }
        else{
        int i=0;
        while(i<this.procesos.size())
         {
            if (this.procesos.get(i).getPagVir()==0)
            {
             int j=0;
        
             while (j<this.procesos.get(i).getNroPag()){
                 
                       this.I.virtualids[k].setText(""); 
                       this.I.virtualpags[k].setText("");
                       //System.out.println("id proceso:_"+this.procesos.get(i).getId()+"id pagina:_"+this.procesos.get(i).getPagina(j).getNro());
                       k++;
                   
                    j++;
             }
            }
            else
            {
             int j=0;
        
             while (j<this.procesos.get(i).getNroPag()){
                    if (this.procesos.get(i).getPagina(j).getMemoria()==1)
                    {
                       this.I.virtualids[k].setText(this.procesos.get(i).getId()+""); 
                       this.I.virtualpags[k].setText(this.procesos.get(i).getPagina(j).getNro()+"");
                       //System.out.println("id proceso:_"+this.procesos.get(i).getId()+"id pagina:_"+this.procesos.get(i).getPagina(j).getNro());
                       k++;
                    }
                    j++;
             }
            }             
          i++;   
         }
    }  
    }
        
    public void ImprimirMemRAM()
    {  int k=0;//apuntador al marco;
       int i;//nro proceso
       int j;//nro de pagina
       while (k<this.marcos.length){
             //this.I.marcos[k].setText("|--marco "+k+"--|"+"           "+"  "+i+"  "+j);
              if(this.marcos[k].getMarcoDisp()==0){//Si esta disponible lo imprimo tal cual
                 this.I.marcos[k].setText("|--marco "+k+"--|");
              }
              else{//Si esta ocupado
                  i=this.marcos[k].getIdProceso();
                  j=this.marcos[k].getNro();
                  this.I.marcos[k].setText("|--marco "+k+"--|"+"           "+"  "+i+"  "+j);
              }
       k++;
       }
    
    }
    
    public void EjecutarAgain(){
           this.Ejecutar();
    }
   public void EjecutarAgain2(int idProc, int nroPag){
           this.Ejecutar2(idProc,nroPag);
    }
     public void Ejecutar2(int idProc, int nroPag)
    {  
       int idP=idProc;
       int nroPg=nroPag;
       
       this.ImprimirProcesos();
       if(idP==this.procesos.size()){
           
        this.actualizarPC();
        System.out.println("this.PC:_"+idP+" es igual a el nro de procesos:_"+this.procesos.size());
       }
       else{
           System.out.println("idP_"+idP);
           if (this.procesos.get(idP).getPCpag()==-1){//Si el proceso esta terminado
               System.out.println("El proceso se ha terminado");
       //    actualiza la informacion en la interfaz y en el proceso y sus paginas
             this.BorrarMarcos(idP);
             //Actualizar la informacion de las paginas del proceso.
             int i=0;
             while(i<this.procesos.get(idP).getNroPag()){
                   this.procesos.get(idP).getPagina(i).setMemoria(1);
                   i++;
             }
             this.procesos.get(idP).setPagRam(0);
             this.procesos.get(idP).setPagVir(this.procesos.get(idP).getNroPag());
             this.ImprimirMemVirtual();
             this.ImprimirProcesos();
             //Actualizar el estado del proceso
             this.procesos.get(idP).setEstado(4);
             this.I.estados[idP].setText("Terminado");
             this.I.textarea2.setText("...");
             //this.actualizarPC();
             
            
          }       
          
           else{
                //Ejecutar la pagina nroPg del proceso idP.
                //Si la pagina del proceso esta en RAM
                if(this.procesos.get(idP).getPagina(nroPg).getMemoria()==0){
                   int marco=this.procesos.get(idP).getPagina(nroPg).getMarcoDonde();
                   if (this.bitDeUso[marco]==0){
                       this.bitDeUso[marco]=1;
                   }
                  
                   System.out.println("La pagina esta en memoria RAM...Ejecutando...");
                   this.procesos.get(idP).setEstado(3);
                   this.I.estados[idP].setText("Ejecutando");
                   this.I.textarea2.setText("Ejecutando:_   PROCESO "+idP+"  PAGINA:_   "+this.procesos.get(idP).getPagina(nroPg).getNro());                           
              
                   this.procesos.get(idP).actualizarPCpag();
                  
                   System.out.println("PCpag:_ "+this.procesos.get(idP).getPCpag());
                   this.procesos.get(idP).setEstado(1);
                   //this.actualizarPC();
                }
                else{//Sino esta en memoria, la mando a poner en memoria y la ejecuto
                     System.out.println("La pagina esta en memoria virtual, se buscara para ejecutar...id");
                     this.UbicarPagEnRAM2(idP,nroPg);
                     this.EjecutarAgain2(idP,nroPg);                     
                    }
            
         }
       }
       
             
   }     

    
    public void Ejecutar()
    {  
       this.ImprimirProcesos();
       if(this.PC==this.procesos.size()){
           
        this.actualizarPC();
        System.out.println("this.PC:_"+this.PC+" es igual a el nro de procesos:_"+this.procesos.size());
       }
       else{
           System.out.println("this.PC_"+this.PC);
           if (this.procesos.get(this.PC).getPCpag()==-1){//Si el proceso esta terminado
               System.out.println("El proceso se ha terminado");
       //    actualiza la informacion en la interfaz y en el proceso y sus paginas
             this.BorrarMarcos(this.PC);
             //Actualizar la informacion de las paginas del proceso.
             int i=0;
             while(i<this.procesos.get(this.PC).getNroPag()){
                   this.procesos.get(this.PC).getPagina(i).setMemoria(1);
                   i++;
             }
             this.procesos.get(this.PC).setPagRam(0);
             this.procesos.get(this.PC).setPagVir(this.procesos.get(this.PC).getNroPag());
             this.ImprimirMemVirtual();
             this.ImprimirProcesos();
             //Actualizar el estado del proceso
             this.procesos.get(this.PC).setEstado(4);
             this.I.estados[this.PC].setText("Terminado");
             this.I.textarea2.setText("...");
             this.PC2=this.PC+1;
             this.actualizarPC();
             
            
          }       
          
           else{
                //Ejecutar una pag del proceso cuyo id se indica en el PC.
                //Si la pagina del proceso esta en RAM
                if(this.procesos.get(this.PC).getPagina(this.procesos.get(this.PC).getPCpag()).getMemoria()==0){
                   int marco=this.procesos.get(this.PC).getPagina(this.procesos.get(this.PC).getPCpag()).getMarcoDonde();
                   if (this.bitDeUso[marco]==0){
                       this.bitDeUso[marco]=1;
                   }
                  
                   System.out.println("La pagina esta en memoria RAM...Ejecutando...");
                   this.procesos.get(this.PC).setEstado(3);
                   this.I.estados[this.PC].setText("Ejecutando");
                   this.I.textarea2.setText("Ejecutando:_   PROCESO "+this.PC+"  PAGINA:_   "+this.procesos.get(this.PC).getPagina(this.procesos.get(this.PC).getPCpag()).getNro());                           
              
                   this.procesos.get(this.PC).actualizarPCpag();
                  
                   System.out.println("PCpag:_ "+this.procesos.get(this.PC).getPCpag());
                   this.procesos.get(this.PC).setEstado(1);
                   this.actualizarPC();
                }
                else{//Sino esta en memoria, la mando a poner en memoria y la ejecuto
                     System.out.println("La pagina esta en memoria virtual, se buscara para ejecutar...id");
                     this.UbicarPagEnRAM(this.PC);
                     this.EjecutarAgain();                     
                    }
            
         }
       }
       
             
   }     

    public void BorrarMarcos(int id){//Me das el id del proceso y se borran todos
                                    //los marcos que contienen paginas de ese proceso.
    int i=0;
    
    while (i<this.nroMarcos){
    
       if (this.marcos[i].getMarcoDisp()==0){//Si el marco esta disponible no hago nada
          //skip
       }
       else
       {
         if(this.marcos[i].getIdProceso()==id){
            this.bitDeUso[i]=0; 
            this.marcos[i].setMarcoDisp(0);//se marca como disponible
            this.I.marcos[i].setText("|--marco "+i+"--|");
            this.nroMarcosDisponibles++;
         }
       }
       i++;
    
    }
    
    }
    
    public void UbicarPagEnRAM(int id){//Ubica la pagina indicada por PCpag en RAM
                                       //Actualiza pantalla RAM, Virtual y de lista de procesos.
        
        if(this.nroMarcosDisponibles>0){
        //la meto en ram y ya.
        //Buscar un marco disponible, y colocar la pagina
                         int i=0;
                         int d;
                         boolean encontrado=false;
                         while((i<nroMarcos)&&(encontrado==false)){
                                d=this.marcos[i].getMarcoDisp();
                                if (d==0){//El marco i esta disponible
                                    this.marcos[i]=this.procesos.get(id).getPagina(this.procesos.get(id).getPCpag());
                                    this.procesos.get(id).getPagina(this.procesos.get(id).getPCpag()).setMemoria(0);
                                    this.procesos.get(id).setPagRam(this.procesos.get(id).getPagRam()+1);
                                    this.procesos.get(id).setPagVir(this.procesos.get(id).getPagVir()-1);
                                    this.marcos[i].setMarcoDisp(1);
                                    this.bitDeUso[i]=0;
                                    this.marcos[i].setMarcoDonde(i);
                                    encontrado=true;
                                    this.nroMarcosDisponibles=this.nroMarcosDisponibles-1;
                                }
                                i++;
                         }
         System.out.println("Nro de marcos disponibles:_"+this.nroMarcosDisponibles);                
         this.ImprimirMemRAM();
         this.ImprimirProcesos();
         this.ImprimirMemVirtual();
        }
        else{//Si la memoria esta full, se usa el algoritmo del reloj
             
             while(this.bitDeUso[this.bitPointer]!=0){
                   this.bitDeUso[this.bitPointer]=0;
                   this.actualizarBitPointer();
             }
             System.out.println("se tiene q meter en el marco:_"+this.bitPointer);
             //bitPointer queda apuntando al marco al que hay q reemplazar
             //La pagina que esta en el marco que voy a reemplazar, la pongo en memoria virtual
             this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagina(this.marcos[bitPointer].getNro()).setMemoria(1);
             this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).setPagRam( this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagRam()-1);
             this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).setPagVir( this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagVir()+1);
             if( this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagRam()==0){
                 this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).setEstado(2);
             }
             //Ahora se pone la pagina que se queria meter 
             this.marcos[bitPointer]=this.procesos.get(id).getPagina(this.procesos.get(id).getPCpag());
             this.procesos.get(id).getPagina(this.procesos.get(id).getPCpag()).setMemoria(0);
             if(this.procesos.get(id).getPagRam()==0){
                this.procesos.get(id).setEstado(1);
             }
             this.procesos.get(id).setPagRam(this.procesos.get(id).getPagRam()+1);
             this.procesos.get(id).setPagVir(this.procesos.get(id).getPagVir()-1);
             this.marcos[bitPointer].setMarcoDisp(1);
             this.marcos[bitPointer].setMarcoDonde(bitPointer);
             this.bitDeUso[bitPointer]=0;
             this.ImprimirMemRAM();
             this.ImprimirProcesos();
             this.ImprimirMemVirtual();
             this.actualizarBitPointer();
        }
         
    }
    
      public void UbicarPagEnRAM2(int id,int nroPg){//Ubica la pagina indicada por PCpag en RAM
                                       //Actualiza pantalla RAM, Virtual y de lista de procesos.
        
        if(this.nroMarcosDisponibles!=0){
        //la meto en ram y ya.
        //Buscar un marco disponible, y colocar la pagina
                         int i=0;
                         int d;
                         boolean encontrado=false;
                         while((i<nroMarcos)&&(encontrado==false)){
                                d=this.marcos[i].getMarcoDisp();
                                if (d==0){//El marco i esta disponible
                                    this.marcos[i]=this.procesos.get(id).getPagina(nroPg);
                                    this.procesos.get(id).getPagina(nroPg).setMemoria(0);
                                    this.procesos.get(id).setPagRam(this.procesos.get(id).getPagRam()+1);
                                    this.procesos.get(id).setPagVir(this.procesos.get(id).getPagVir()-1);
                                    this.marcos[i].setMarcoDisp(1);
                                    this.bitDeUso[i]=0;
                                    this.marcos[i].setMarcoDonde(i);
                                    encontrado=true;
                                    this.nroMarcosDisponibles=this.nroMarcosDisponibles-1;
                                }
                                i++;
                         }
         System.out.println("Nro de marcos disponibles:_"+this.nroMarcosDisponibles);                
         this.ImprimirMemRAM();
         this.ImprimirProcesos();
         this.ImprimirMemVirtual();
        }
        else{//Si la memoria esta full, se usa el algoritmo del reloj
             
             while(this.bitDeUso[this.bitPointer]!=0){
                   this.bitDeUso[this.bitPointer]=0;
                   this.actualizarBitPointer();
             }
             System.out.println("se tiene q meter en el marco:_"+this.bitPointer);
             //bitPointer queda apuntando al marco al que hay q reemplazar
             //La pagina que esta en el marco que voy a reemplazar, la pongo en memoria virtual
             this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagina(this.marcos[bitPointer].getNro()).setMemoria(1);
             this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).setPagRam( this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagRam()-1);
             this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).setPagVir( this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagVir()+1);
             if( this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).getPagRam()==0){
                 this.procesos.get(this.marcos[this.bitPointer].getIdProceso()).setEstado(2);
             }
             //Ahora se pone la pagina que se queria meter 
             this.marcos[bitPointer]=this.procesos.get(id).getPagina(nroPg);
             this.procesos.get(id).getPagina(nroPg).setMemoria(0);
             if(this.procesos.get(id).getPagRam()==0){
                this.procesos.get(id).setEstado(1);
             }
             this.procesos.get(id).setPagRam(this.procesos.get(id).getPagRam()+1);
             this.procesos.get(id).setPagVir(this.procesos.get(id).getPagVir()-1);
             this.marcos[bitPointer].setMarcoDisp(1);
             this.marcos[bitPointer].setMarcoDonde(bitPointer);
             this.bitDeUso[bitPointer]=0;
             this.ImprimirMemRAM();
             this.ImprimirProcesos();
             this.ImprimirMemVirtual();
             this.actualizarBitPointer();
        }
         
    }
}
