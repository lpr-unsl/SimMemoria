/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import java.util.ArrayList;

/**
 *
 * @author dearf
 */
public class Manejador {
    
    private int nroMarcos;
    private int nroMarcosDisponibles;
    private Pagina[] marcos; //arreglo de marcos de pagina
    private ArrayList<Proceso> procesos;
    private Pagina pagEjecutandose;//pagina que esta en el procesador
    private int PC; //id del proceso al que le toca ejecutarse
    private Interfaz I;
    private int nroProcesos;
    
    
    
    public Manejador(int nroMarcos,Interfaz I){
      this.nroMarcos=nroMarcos;
      this.nroMarcosDisponibles=nroMarcos;
      this.marcos=new Pagina[nroMarcos];
      this.nroProcesos=0;
      this.PC=0;
      this.procesos=new ArrayList<>();
      this.I=I;
      this.inicializarMarcos();
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
          this.PC=0; 
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
              //skip
            }
            else
            {
             int j=0;
        
             while (j<this.procesos.get(i).getNroPag()){
                    if (this.procesos.get(i).getPagina(j).getMemoria()==1)
                    {
                       this.I.virtualids[k].setText(this.procesos.get(i).getId()+""); 
                       this.I.virtualpags[k].setText(this.procesos.get(i).getPagina(j).getNro()+"");
                       System.out.println("id proceso:_"+this.procesos.get(i).getId()+"id pagina:_"+this.procesos.get(i).getPagina(j).getNro());
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
  
    public void EjecutarSecuencial()
    {
     if(this.PC==this.procesos.size()){
        this.actualizarPC();
        //this.EjecutarSecuencial();
     }
     if(this.PC<this.procesos.size()){
        //if -->el proceso esta terminado
          if (this.procesos.get(this.PC).getPCpag()==-1){
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
             //Actualizar el estado del proceso
             this.procesos.get(this.PC).setEstado(4);
             this.I.estados[this.PC].setText("Terminado");
             this.actualizarPC();
             //this.EjecutarSecuencial();
          }        
        //if--->Si el proceso no esta terminado
          if(this.procesos.get(this.PC).getPCpag()<this.procesos.get(this.PC).getNroPag()){
        //      if--->Si(PCpag esta en memoria)
                if(this.procesos.get(this.PC).getPagina(this.procesos.get(this.PC).getPCpag()).getMemoria()==0){
        //            ejecutar la pagina, actualizar info del proceso y la interfaz
                      this.procesos.get(this.PC).setEstado(3);
                      this.ImprimirProcesos();
                      this.I.textarea2.setText("EJECUTANDO:_"+"     PROCESO:_     "+this.PC+"     PAGINA:_     "+this.procesos.get(this.PC).getPagina(this.procesos.get(this.PC).getPCpag()).getNro());
                      this.procesos.get(this.PC).actualizarPCpag();
                      //Actualizar el estado del proceso
                      if (this.procesos.get(this.PC).getPCpag()==-1){
                          this.procesos.get(this.PC).setEstado(4);
                      }
                      if(this.procesos.get(this.PC).getPCpag()<this.procesos.get(this.PC).getNroPag()){
                          this.procesos.get(this.PC).setEstado(1);
                      }
        //            actualizar el pc del manejador
                      this.ImprimirMemVirtual();
                      this.actualizarPC();
                }
     
        //      if--->Si(PCpag no esta en memoria)
        //            Busco la pagina de la memoria virtual y la pongo en RAM
        //            Pcpag queda igual (se ejecutara cuando el procesador se le asigne otra vez al proceso)
        //            actualizo PC del manejador
        //            this.EjecutarSecuencial();        
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
            this.marcos[i].setMarcoDisp(0);//se marca como disponible
            this.I.marcos[i].setText("|--marco "+i+"--|");
            this.nroMarcosDisponibles++;
         }
       }
       i++;
    
    }
    
    }
    
    
    
    
}
