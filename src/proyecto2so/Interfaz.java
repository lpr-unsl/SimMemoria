/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2so;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author dearf
 */
public class Interfaz extends JFrame implements ActionListener{
    
    //------manejador de memoria--------
     Manejador manejador;
     int nroPaginas_inicial;
     JTextArea[] marcos;
    //--------------------------------------
    
    JPanel panelppal= new JPanel();
   

    JPanel panelNorth=new JPanel(); 
    //Componentes de panelNorth

    //--------------------------
    JPanel panelEast= new JPanel();
    //Componentes de panelEast
    
    JLabel label0=new JLabel("MEMORIA RAM");//Letrerito memoria RAM
    JTextArea textarea1=new JTextArea(""); //textarea RAM
    JScrollPane scrollpane1= new JScrollPane(textarea1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //---------------------------
    JPanel panelCenter= new JPanel();
    //Componentes de panelCenter
    JPanel virtualid=new JPanel();//columna id de la pantalla memoria virtual
    JPanel virtualpag=new JPanel();//columna pag de la pantalla memoria virtual
    JTextArea[] virtualids;
    JTextArea[] virtualpags;
    
    JTextArea textarea2=new JTextArea(""); //Pantalla procesador
    JPanel panelWest=new JPanel();
    JButton siguiente=new JButton("Ejecutar siguiente");//ejecutar siguiente proceso en la cola de listos
    JTextArea textarea3=new JTextArea();
    JTextArea textarea4=new JTextArea();
    JLabel textarea3Label=new JLabel("Indique Nro de Proceso");
    JLabel textarea4Label=new JLabel("Indique Nro de Pagina");
    JButton ejecutar=new JButton("Ejecutar pagina indicada");//ejecutar proceso indicando nro de pagina y de proceso
    JLabel label2=new JLabel("                                                                        PROCESADOR");//Letrerito que dice procesador
    JLabel label3=new JLabel("                                                                    MEMORIA VIRTUAL");//Letrerito que dice memoria virtual
    JLabel label4=new JLabel("                               ID del Proceso");//Letrerito ID de tabla memoria virtual
    JLabel label5=new JLabel("                               Nro de Pagina");//Letrerito de tabla memoria virtual
    JTextArea textarea8=new JTextArea("");//Pantalla columna ID memoria virtual
    JTextArea textarea9=new JTextArea("");//Pantall nro pagina memoria virtual
     JScrollPane scrollpane2= new JScrollPane(virtualid,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      JScrollPane scrollpane3= new JScrollPane(virtualpag,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //Componentes de panelWest
      
     JTextArea[] ids;
     JTextArea[] totalpgs;
     JTextArea[] totalrams;
     JTextArea[] nrodiscos;
     JTextArea[] estados;  
      
      
    JLabel label6= new JLabel("Lista de Procesos");//Letrerito que dice lista de procesos
    JLabel label7=new JLabel("ID");//columna id de lista de procesos--letrerito
    JLabel label8=new JLabel("#Total pg");//columna lista de procesos letrero paginas totales
    JLabel label9=new JLabel("#Pag RAM");//columna lista de procesos letrero paginas en memoria
    JLabel label10=new JLabel("#Pag Disco");//columna lista de procesos paginas en memoria virtual
    JLabel label11=new JLabel("Estado");//columna lista de procesos Estado
    JTextArea textarea10=new JTextArea("\n"); //lista de procesos, columna ID
    JTextArea textarea11=new JTextArea("\n"); //lista de procesos columna paginas totales
    JTextArea textarea12=new JTextArea("\n"); //lista de procesos columna paginas en memoria
    JTextArea textarea13=new JTextArea("\n");// lista de procesos columna paginas en memoria virtual
    JTextArea textarea14=new JTextArea("\n");// lista de procesos columna estado.
    JScrollPane scrollpane4= new JScrollPane(textarea10,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollpane5= new JScrollPane(textarea11,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollpane6= new JScrollPane(textarea12,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollpane7= new JScrollPane(textarea13,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scrollpane8= new JScrollPane(textarea14,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JLabel label12= new JLabel("\n                                CREAR PROCESO \n");
    JTextArea textarea15=new JTextArea("CREAR PROCESO VA AQUI");//Para crear el proceso...
    JButton crearProceso=new JButton("crear proceso");
    JTextArea nroPaginas=new JTextArea("");
    JLabel digaPaginas=new JLabel("Tipee el nro de paginas");
    JButton secuencial=new JButton("crear con ejecucion secuencial");
    JButton nosecuencial=new JButton("crear con ejecucion personalizada");
    JLabel blank=new JLabel("");
    JLabel blank2=new JLabel("Tipee el nro de paginas que desea");
    JLabel blank3=new JLabel("");
    JLabel tipeeNoSec=new JLabel("secuencia,Al final -00.Ejemplo:1-0-2-3-00");
    JTextArea sec=new JTextArea("-00");
    JTextArea nroPaginasNoSec=new JTextArea("");
    //------Inicio---------------------------------
      JPanel inicio=new JPanel();
      JTextArea textarea00=new JTextArea("");
      JButton crearMarco=new JButton("crear marcos");
      JLabel inicioLabel=new JLabel("Introduzca el nro de marcos que desea en memoria ppal");
    //---------------------------------------------  
    public void start(){
          setSize(600,200);
	  setResizable(true);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          inicio.setLayout(new BorderLayout());
          textarea00.setEditable(true);
	  textarea00.setLineWrap(true);
          textarea00.setWrapStyleWord(true);
          textarea00.setFont(new Font("Arial ", Font.BOLD, 14));
          textarea00.setBorder(BorderFactory.createLineBorder(Color.black));
          textarea00.setBackground(Color.white);
          textarea00.setForeground(Color.black);
          JScrollPane scrollpane00= new JScrollPane(textarea00,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
            ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          inicioLabel.setFont(new Font("Arial ", Font.BOLD, 18));
          inicioLabel.setBorder(BorderFactory.createRaisedBevelBorder());
          this.crearMarco.setFont(new Font("Arial ", Font.BOLD, 18));
          this.crearMarco.setBorder(BorderFactory.createRaisedBevelBorder());
          this.crearMarco.addActionListener(this);
          inicio.add(inicioLabel,BorderLayout.PAGE_START);
          inicio.add(scrollpane00,BorderLayout.CENTER);
          inicio.add(crearMarco,BorderLayout.PAGE_END);
          add(this.inicio);
          setVisible(true);
    }
    public void Go(int nroMarcos){
                manejador=new Manejador(nroMarcos,this);
                setSize(600,400);
	 	setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                //----PANEL PPAL------------------------------
                this.panelppal.setLayout(new  GridLayout(1,3));
                this.panelppal.add(panelEast);
                this.panelppal.add(panelCenter);
                this.panelppal.add(panelWest);
                //---PANEL EAST------------------------------
              
                this.marcos=new JTextArea[nroMarcos];
                int i=0;
                while(i<nroMarcos){
                marcos[i]=new JTextArea("marco "+i);
                marcos[i].setEditable(true);
		marcos[i].setLineWrap(true);
		marcos[i].setWrapStyleWord(true);
                marcos[i].setFont(new Font("Arial ", Font.BOLD,18));
                marcos[i].setBorder(BorderFactory.createLineBorder(Color.black));
                marcos[i].setBackground(Color.white);
                marcos[i].setForeground(Color.blue);
                i++;
                }
                JPanel ram=new JPanel();
                ram.setLayout(new GridLayout(nroMarcos,1));
                JScrollPane ramScroll= new JScrollPane(ram,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
                ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                this.panelEast.setLayout(new BorderLayout());
                this.panelEast.add(label0,BorderLayout.PAGE_START);
                i=0;
                while(i<nroMarcos){
                     ram.add(marcos[i]);
                     i++;
                }
                 this.panelEast.add(ramScroll,BorderLayout.CENTER);
                //-------------------------------------------
                //---PANEL CENTER----------------------------
                this.panelCenter.setLayout(new GridLayout(2,1));
                JPanel center=new JPanel();//Mitad de arriba de panel center
               
                center.setLayout(new GridLayout(8,1));
                center.add(label2);
                center.add(textarea2);
                center.add(siguiente);
                center.add(textarea3Label);
                center.add(textarea3);
                center.add(textarea4Label);
                center.add(textarea4);
                center.add(ejecutar);
                JPanel center2=new JPanel();//Mitad de abajo de panel center
                center2.setLayout(new BorderLayout());
                JPanel center2Grid= new JPanel();
                center2Grid.setLayout(new GridLayout(2,1));
                JPanel center2Grid2=new JPanel();
                center2Grid2.setLayout(new GridLayout(1,3));
                center2.add(center2Grid,BorderLayout.PAGE_START);
                center2Grid.add(label3);
                center2Grid.add(center2Grid2);
                center2Grid2.add(label4);
                center2Grid2.add(label5);
                JPanel center2center=new JPanel();
                center2center.setLayout(new GridLayout(1,2));
                virtualid.setLayout(new GridLayout(1000,1));
                virtualpag.setLayout(new GridLayout(1000,1));
                virtualids=new JTextArea[1000];
                virtualpags=new JTextArea[1000];
                int k=0;
                   while (k<1000)
                {
                  virtualids[k]=new JTextArea();
                  virtualpags[k]=new JTextArea();
                  
                  virtualids[k].setEditable(true);
		  virtualids[k].setLineWrap(true);
		  virtualids[k].setWrapStyleWord(true);
                  virtualids[k].setFont(new Font("Arial ", Font.BOLD, 18));
                  virtualids[k].setBorder(BorderFactory.createLineBorder(Color.black));
                  virtualpags[k].setEditable(true);
		  virtualpags[k].setLineWrap(true);
		  virtualpags[k].setWrapStyleWord(true);
                  virtualpags[k].setFont(new Font("Arial ", Font.BOLD, 18));
                  virtualpags[k].setBorder(BorderFactory.createLineBorder(Color.black));
                  virtualpags[k].setForeground(Color.red);
                  virtualpag.add(virtualids[k]);
                  virtualpag.add(virtualpags[k]);
                  k++;
                }
                
                center2.add(scrollpane2);
                center2center.add(scrollpane3);
                center2.add(center2center, BorderLayout.CENTER);
                this.panelCenter.add(center);
                this.panelCenter.add(center2);
                //--------------------------------------------------
                //--PANEL WEST--------------------------------------
                this.panelWest.setLayout(new BorderLayout());
                JPanel starGrid= new JPanel();
                starGrid.setLayout(new GridLayout(2,1));
                starGrid.add(label6);
                JPanel starGridFiladeAbajo=new JPanel();
                starGridFiladeAbajo.setLayout(new GridLayout(1,5));
                starGridFiladeAbajo.add(label7);
                starGridFiladeAbajo.add(label8);
                starGridFiladeAbajo.add(label9);
                starGridFiladeAbajo.add(label10);
                starGridFiladeAbajo.add(label11);
                starGrid.add(starGridFiladeAbajo);
                JPanel westCenter= new JPanel();
                westCenter.setLayout(new GridLayout(1,5));
               
                
                
                JPanel id=new JPanel();
                JPanel totalpg=new JPanel();
                JPanel totalram=new JPanel();
                JPanel nrodisco=new JPanel();
                JPanel estado=new JPanel();
                
                JScrollPane scrollid= new JScrollPane(id,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
               ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollPane scrolltotalpg= new JScrollPane(totalpg,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
               ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollPane scrolltotalram= new JScrollPane(totalram,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
               ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollPane scrollnrodisco= new JScrollPane(nrodisco,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
               ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                JScrollPane scrollestado= new JScrollPane(estado,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
               ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                
                id.setLayout(new GridLayout(1000,1));
                totalpg.setLayout(new GridLayout(1000,1));
                totalram.setLayout(new GridLayout(1000,1));
                nrodisco.setLayout(new GridLayout(1000,1));
                estado.setLayout(new GridLayout(1000,1));
                int j=0;
                ids=new JTextArea[1000];
                totalpgs=new JTextArea[1000];
                totalrams=new JTextArea[1000];
                nrodiscos=new JTextArea[1000];
                estados=new JTextArea[1000];
                while (j<1000)
                {
                  ids[j]=new JTextArea();
                  totalpgs[j]=new JTextArea();
                  totalrams[j]=new JTextArea();
                  nrodiscos[j]=new JTextArea();
                  estados[j]=new JTextArea();
                  ids[j].setEditable(true);
		  ids[j].setLineWrap(true);
		  ids[j].setWrapStyleWord(true);
                  ids[j].setFont(new Font("Arial ", Font.BOLD, 12));
                  ids[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  totalpgs[j].setEditable(true);
		  totalpgs[j].setLineWrap(true);
		  totalpgs[j].setWrapStyleWord(true);
                  totalpgs[j].setFont(new Font("Arial ", Font.BOLD, 12));
                  totalpgs[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  totalrams[j].setEditable(true);
		  totalrams[j].setLineWrap(true);
		  totalrams[j].setWrapStyleWord(true);
                  totalrams[j].setFont(new Font("Arial ", Font.BOLD, 12));
                  totalrams[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  nrodiscos[j].setEditable(true);
		  nrodiscos[j].setLineWrap(true);
		  nrodiscos[j].setWrapStyleWord(true);
                  nrodiscos[j].setFont(new Font("Arial ", Font.BOLD, 12));
                  nrodiscos[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  estados[j].setEditable(true);
		  estados[j].setLineWrap(true);
		  estados[j].setWrapStyleWord(true);
                  estados[j].setFont(new Font("Arial ", Font.BOLD, 12));
                  estados[j].setForeground(Color.blue);
                  estados[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  id.add(ids[j]);
                  totalpg.add(totalpgs[j]);
                  totalram.add(totalrams[j]);
                  nrodisco.add(nrodiscos[j]);
                  estado.add(estados[j]);
                  j++;
                }
                westCenter.add(scrollid);
                westCenter.add(scrolltotalpg);
                westCenter.add(scrolltotalram);
                westCenter.add(scrollnrodisco);
                westCenter.add(scrollestado);
                JPanel westPageEnd=new JPanel();
                westPageEnd.setLayout(new BorderLayout());
                this.label12.setFont(new Font("Arial ", Font.BOLD, 18));
                westPageEnd.add(label12, BorderLayout.PAGE_START);
                JPanel crearProc=new JPanel();
                crearProc.setLayout(new GridLayout(7,2));
                crearProc.add(digaPaginas);
                crearProc.add(nroPaginas);
                crearProc.add(blank);
                crearProc.add(secuencial);
                crearProc.add(tipeeNoSec);
                crearProc.add(sec);
                crearProc.add(blank2);
                crearProc.add(nroPaginasNoSec);
                crearProc.add(blank3);
                crearProc.add(nosecuencial);
                westPageEnd.add(crearProc, BorderLayout.CENTER);
                //westPageEnd.add(nosecuencial,BorderLayout.PAGE_END);
                this.panelWest.add(starGrid, BorderLayout.PAGE_START);
                this.panelWest.add(westCenter, BorderLayout.CENTER);
                this.panelWest.add(westPageEnd,BorderLayout.PAGE_END);
                //--------Configuracion de todos los botones--------------------
                this.crearProceso.addActionListener(this);
                this.crearProceso.setFont(new Font("Arial ", Font.BOLD, 14));
                this.secuencial.addActionListener(this);
                this.secuencial.setFont(new Font("Arial ", Font.BOLD, 13));
                this.nosecuencial.addActionListener(this);
                this.nosecuencial.setFont(new Font("Arial ", Font.BOLD, 13));
                this.siguiente.addActionListener(this);
                this.siguiente.setFont(new Font("Arial ", Font.BOLD, 18));
                this.ejecutar.addActionListener(this);
                this.ejecutar.setFont(new Font("Arial ", Font.BOLD, 18));
                //--------Configuracion de todos los textarea y jlabel-------------------
                this.textarea2.setEditable(true);
		this.textarea2.setLineWrap(true);
		this.textarea2.setWrapStyleWord(true);
                this.textarea2.setFont(new Font("Arial ", Font.BOLD, 18));
                this.textarea2.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea2.setForeground(Color.magenta);
                this.textarea3.setEditable(true);
		this.textarea3.setLineWrap(true);
		this.textarea3.setWrapStyleWord(true);
                this.textarea3.setFont(new Font("Arial ", Font.BOLD, 18));
                this.textarea3.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea3.setForeground(Color.gray);
                this.textarea3.setEditable(true);
                
		this.textarea4Label.setFont(new Font("Arial ", Font.BOLD, 18));
                this.textarea4Label.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea4Label.setForeground(Color.blue);
		
                this.textarea3Label.setFont(new Font("Arial ", Font.BOLD, 18));
                this.textarea3Label.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea3Label.setForeground(Color.blue);
                this.textarea3.setEditable(true);
		this.textarea4.setLineWrap(true);
		this.textarea4.setWrapStyleWord(true);
                this.textarea4.setFont(new Font("Arial ", Font.BOLD, 18));
                this.textarea4.setBorder(BorderFactory.createLineBorder(Color.black));
                this.textarea4.setForeground(Color.gray);
                this.nroPaginas.setEditable(true);
		this.nroPaginas.setLineWrap(true);
		this.nroPaginas.setWrapStyleWord(true);
                this.nroPaginas.setFont(new Font("Arial ", Font.BOLD, 18));
                this.nroPaginas.setBorder(BorderFactory.createLineBorder(Color.black));
                this.nroPaginas.setForeground(Color.red);
                this.nroPaginasNoSec.setEditable(true);
		this.nroPaginasNoSec.setLineWrap(true);
		this.nroPaginasNoSec.setWrapStyleWord(true);
                this.nroPaginasNoSec.setFont(new Font("Arial ", Font.BOLD, 18));
                this.nroPaginasNoSec.setBorder(BorderFactory.createLineBorder(Color.black));
                this.nroPaginasNoSec.setForeground(Color.black);
                this.sec.setEditable(true);
		this.sec.setLineWrap(true);
		this.sec.setWrapStyleWord(true);
                this.sec.setFont(new Font("Arial ", Font.BOLD, 18));
                this.sec.setBorder(BorderFactory.createLineBorder(Color.black));
                this.sec.setForeground(Color.RED);
                this.textarea15.setEditable(true);
		this.textarea15.setLineWrap(true);
		this.textarea15.setWrapStyleWord(true);
                this.textarea15.setFont(new Font("Arial ", Font.BOLD, 18));
                this.textarea15.setBorder(BorderFactory.createLineBorder(Color.black));
                //--------------------------------------------------------------------
                
                add(this.panelppal);
                setVisible(true);
                
    }
   
    
    
    @Override
    public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
	        if (src.equals(crearMarco)){
                       
                       String s=textarea00.getText();
                       int n;
                       if (s.equals("")){
                           this.textarea00.setText("Como no coloco nada, se crearan 10 marcos");
                           n=10;
                       }
                       else
                       {                           
                       n=Integer.parseInt(s);
                       }
                       inicio.setVisible(false);
                       this.Go(n);
                    
                }
                if (src.equals(secuencial)){
                       String s=this.nroPaginas.getText();
                       if (s.equals("")){
                           this.nroPaginas.setText("tipee un nro para comenzar");
                       }
                       else{
                       int pags=Integer.parseInt(this.nroPaginas.getText());
                       if ((pags<0)||(pags==0)){
                          this.nroPaginas.setText("Tipee un nro mayor a cero");
                       }
                       else{
                       this.manejador.crearProceso(pags);
                       this.manejador.ImprimirProcesos();
                       this.manejador.ImprimirMemVirtual();
                       this.manejador.ImprimirMemRAM();
                       }
                       }
                }
                if (src.equals(siguiente)){
                    this.manejador.Ejecutar();
                }
                if (src.equals(ejecutar)){
                   int idProc=Integer.parseInt(this.textarea3.getText());
                   int nroPag=Integer.parseInt(this.textarea4.getText());
                   System.out.println("nro proceso:_"+idProc+"nro pagina:_"+nroPag);
                   this.manejador.Ejecutar2(idProc, nroPag);
                }
                
                
                if(src.equals(nosecuencial)){
                   String secuencia=this.sec.getText();
                   int n=Integer.parseInt(this.nroPaginasNoSec.getText());
                   ArrayList<String> listTemp=new ArrayList<>();
                   int[] arreglos_PCpag;
                   String s,k,temp="";
                   int i,g;
                   i=0;
                   while(i<=secuencia.length()){
                   if (i<secuencia.length()-1){    
                   if(Character.toString(secuencia.charAt(i)).equals("-")){
                        listTemp.add(temp);
                        //System.out.print("i:_"+i+" temp:_"+temp+" ");
                        temp="";
                     }else{
                          temp=temp+Character.toString(secuencia.charAt(i));
                      }
                   }
                   else{
                    listTemp.add(Character.toString(secuencia.charAt(secuencia.length()-1)));
                    int x=secuencia.length()-1;
                   //System.out.print("i:_"+x+" temp:_"+listTemp.get(listTemp.size()-1)+" ");
                   }
                    i++;
                   }
                  //Ahora armo el arreglo de PCpag
                  i=0;
                  arreglos_PCpag=new int[listTemp.size()-2];
                  while(i<arreglos_PCpag.length){
                     arreglos_PCpag[i]=Integer.parseInt(listTemp.get(i));
                     //System.out.print("arreglos["+i+"]:_____"+arreglos_PCpag[i]+"\n");
                     i++;
                   }
                  //Ahora llamo a crear el proceso...
                       this.manejador.crearProceso_NoSecuencial(n,arreglos_PCpag);
                       this.manejador.ImprimirProcesos();
                       this.manejador.ImprimirMemVirtual();
                       this.manejador.ImprimirMemRAM();
                  
             }
                
        }
}
