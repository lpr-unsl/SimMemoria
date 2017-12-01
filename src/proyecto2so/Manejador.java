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
    
    private void inicializarMarcos(){
    
        int i=0;
        while (i<nroMarcos){
        
            marcos[i]=new Pagina(-1,i);
            i++;
        }
    
    }
    
    public Manejador(int nroMarcos,Interfaz I){
      this.nroMarcos=nroMarcos;
      this.nroMarcosDisponibles=nroMarcos;
      this.marcos=new Pagina[nroMarcos];
      this.nroProcesos=0;
      this.procesos=new ArrayList<>();
      this.I=I;
      this.inicializarMarcos();
    }
   
    public void crearProceso(int cuantasPag){
        Proceso p;  
        p=new Proceso(procesos.size(),cuantasPag);
        procesos.add(p);
        this.nroProcesos++;
        int x=procesos.size()-1;
        this.I.textarea15.setText("Se ha creado el proceso "+x);
        
        if(this.nroMarcosDisponibles>0){
           this.procesos.get(this.procesos.size()-1).getPagina(0).setMemoria(0);
           this.procesos.get(this.procesos.size()-1).setEstado(1);
           this.procesos.get(this.procesos.size()-1).setPagRam(this.procesos.get(this.procesos.size()-1).getPagRam()+1);
           this.procesos.get(this.procesos.size()-1).setPagVir(this.procesos.get(this.procesos.size()-1).getNroPag()-1); 
           this.nroMarcosDisponibles=this.nroMarcosDisponibles-1;
           }
        else{
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
       int i=0;
       while (i<this.procesos.size()){
              int j=0;
              while(j<this.procesos.get(i).getNroPag()){
                    if (this.procesos.get(i).getPagina(j).getMemoria()==0){
                        this.I.marcos[k].setText("|--marco "+k+"--|"+"           "+"  "+i+"  "+j);
                        k++;
                    }
                    j++;
              }
       i++;
       }
    
    }
  
    public void EjecutarSecuencial()
    {
      if (this.nroMarcosDisponibles>0)//Poner una de las paginas del proceso en ram, lo demas en virtual
      {
         //Meto la primera pagina del proceso recien creado en ram
         this.procesos.get(this.procesos.size()-1).setPC(1);
         this.procesos.get(this.procesos.size()-1).getPagina(0).setMemoria(0);
         //ImprimirMemRAM();
         //ImprimirMemVirtual();
         //ImprimirProcesos();
      }
      {
      
      }
    
    
    }
}
