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
    
    JTextArea textarea2=new JTextArea("Ejecutado:_ P11"); //Pantalla procesador
    JPanel panelWest=new JPanel();
    JButton siguiente=new JButton("siguiente");//ejecutar siguiente proceso en la cola de listos
    JTextArea textarea3=new JTextArea("Nro de Proceso");
    JTextArea textarea4=new JTextArea("Nro de Pagina");
    JButton ejecutar=new JButton("Ejecutar");//ejecutar proceso indicando nro de pagina y de proceso
    JLabel label2=new JLabel("PROCESADOR");//Letrerito que dice procesador
    JLabel label3=new JLabel("Memoria Virtual");//Letrerito que dice memoria virtual
    JLabel label4=new JLabel("ID");//Letrerito ID de tabla memoria virtual
    JLabel label5=new JLabel("#Pagina");//Letrerito de tabla memoria virtual
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
    JLabel label12= new JLabel("Crear Proceso");
    JTextArea textarea15=new JTextArea("CREAR PROCESO VA AQUI");//Para crear el proceso...
    JButton crearProceso=new JButton("crear proceso");
    
    //------Inicio------------------------------
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
                marcos[i].setFont(new Font("Arial ", Font.BOLD,12));
                marcos[i].setBorder(BorderFactory.createLineBorder(Color.black));
                marcos[i].setBackground(Color.white);
                marcos[i].setForeground(Color.black);
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
               
                center.setLayout(new GridLayout(6,1));
                center.add(label2);
                center.add(textarea2);
                center.add(siguiente);
                center.add(textarea3);
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
                  ids[j].setFont(new Font("Arial ", Font.BOLD, 18));
                  ids[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  totalpgs[j].setEditable(true);
		  totalpgs[j].setLineWrap(true);
		  totalpgs[j].setWrapStyleWord(true);
                  totalpgs[j].setFont(new Font("Arial ", Font.BOLD, 18));
                  totalpgs[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  totalrams[j].setEditable(true);
		  totalrams[j].setLineWrap(true);
		  totalrams[j].setWrapStyleWord(true);
                  totalrams[j].setFont(new Font("Arial ", Font.BOLD, 18));
                  totalrams[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  nrodiscos[j].setEditable(true);
		  nrodiscos[j].setLineWrap(true);
		  nrodiscos[j].setWrapStyleWord(true);
                  nrodiscos[j].setFont(new Font("Arial ", Font.BOLD, 18));
                  nrodiscos[j].setBorder(BorderFactory.createLineBorder(Color.black));
                  estados[j].setEditable(true);
		  estados[j].setLineWrap(true);
		  estados[j].setWrapStyleWord(true);
                  estados[j].setFont(new Font("Arial ", Font.BOLD, 18));
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
                westPageEnd.add(label12, BorderLayout.PAGE_START);
                westPageEnd.add(textarea15, BorderLayout.CENTER);
                westPageEnd.add(crearProceso,BorderLayout.PAGE_END);
                this.panelWest.add(starGrid, BorderLayout.PAGE_START);
                this.panelWest.add(westCenter, BorderLayout.CENTER);
                this.panelWest.add(westPageEnd,BorderLayout.PAGE_END);
                //--------Configuracion de todos los botones--------------------
                this.crearProceso.addActionListener(this);
                //--------Configuracion de todos los textarea-------------------
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
                if (src.equals(crearProceso)){
                       this.manejador.crearProceso();
                       this.manejador.ImprimirProcesos();
                      
                }
                
        }
}
