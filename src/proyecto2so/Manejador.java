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
    private Pagina[] marcos; //arreglo de marcos de pagina
    private ArrayList<Proceso> procesos;
    private int PC; //id del proceso al que le toca ejecutarse
    private Interfaz I;
    private int nroProcesos;
    public Manejador(int nroMarcos,Interfaz I){
      this.nroMarcos=nroMarcos;
      this.marcos=new Pagina[nroMarcos];
      this.nroProcesos=0;
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
    
    public void crearProceso(){
        Proceso p;  
        p=new Proceso(procesos.size(),4);
        procesos.add(p);
        this.nroProcesos++;
        int x=procesos.size()-1;
        this.I.textarea15.setText("Se ha creado el proceso "+x);
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
    
                 if (this.nroProcesos==0){
            
            //skip
        }
        else{
        int i=0;
        while(i<this.procesos.size())
         {
             
             
          i++;   
         }
    }  
        
    }
    
}
