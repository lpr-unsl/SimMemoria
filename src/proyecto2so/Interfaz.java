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
     JScrollPane scrollpane2= new JScrollPane(textarea8,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      JScrollPane scrollpane3= new JScrollPane(textarea9,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //Componentes de panelWest
    JLabel label6= new JLabel("Lista de Procesos");//Letrerito que dice lista de procesos
    JLabel label7=new JLabel("ID");//columna id de lista de procesos--letrerito
    JLabel label8=new JLabel("#Total pg");//columna lista de procesos letrero paginas totales
    JLabel label9=new JLabel("#Pag RAM");//columna lista de procesos letrero paginas en memoria
    JLabel label10=new JLabel("#Pag Disco");//columna lista de procesos paginas en memoria virtual
    JLabel label11=new JLabel("Estado");//columna lista de procesos Estado
    JTextArea textarea10=new JTextArea(); //lista de procesos, columna ID
    JTextArea textarea11=new JTextArea(); //lista de procesos columna paginas totales
    JTextArea textarea12=new JTextArea(); //lista de procesos columna paginas en memoria
    JTextArea textarea13=new JTextArea();// lista de procesos columna paginas en memoria virtual
    JTextArea textarea14=new JTextArea();// lista de procesos columna estado.
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
      JTextArea textarea00=new JTextArea();
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
                   
                setSize(600,400);
	 	setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                //----PANEL PPAL------------------------------
                this.panelppal.setLayout(new  GridLayout(1,3));
                this.panelppal.add(panelEast);
                this.panelppal.add(panelCenter);
                this.panelppal.add(panelWest);
                //---PANEL EAST------------------------------
                JTextArea[] marcos=new JTextArea[nroMarcos];
                int i=0;
                while(i<nroMarcos){
                marcos[i]=new JTextArea("marco "+i);
                marcos[i].setEditable(true);
		marcos[i].setLineWrap(true);
		marcos[i].setWrapStyleWord(true);
                marcos[i].setFont(new Font("Arial ", Font.BOLD, 18));
                marcos[i].setBorder(BorderFactory.createLineBorder(Color.black));
                marcos[i].setBackground(Color.white);
                marcos[i].setForeground(Color.black);
                i++;
                }
                JPanel ram=new JPanel();
                ram.setLayout(new GridLayout(nroMarcos,1));
                this.panelEast.setLayout(new BorderLayout());
                this.panelEast.add(label0,BorderLayout.PAGE_START);
                i=0;
                while(i<nroMarcos){
                     ram.add(marcos[i]);
                     i++;
                }
                 this.panelEast.add(ram,BorderLayout.CENTER);
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
                center2center.add(scrollpane2);
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
                westCenter.add(scrollpane4);
                westCenter.add(scrollpane5);
                westCenter.add(scrollpane6);
                westCenter.add(scrollpane7);
                westCenter.add(scrollpane8);
                JPanel westPageEnd=new JPanel();
                westPageEnd.setLayout(new BorderLayout());
                westPageEnd.add(label12, BorderLayout.PAGE_START);
                westPageEnd.add(textarea15, BorderLayout.CENTER);
                westPageEnd.add(crearProceso,BorderLayout.PAGE_END);
                this.panelWest.add(starGrid, BorderLayout.PAGE_START);
                this.panelWest.add(westCenter, BorderLayout.CENTER);
                this.panelWest.add(westPageEnd,BorderLayout.PAGE_END);
             
                //-------------------------------------------------
                add(this.panelppal);
                setVisible(true);
  
    }
   
    
    
    @Override
    public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
	        if (src.equals(crearMarco)){
                       inicio.setVisible(false);
                       String s=textarea00.getText();
                       int n=Integer.parseInt(s);
                       this.Go(n);
                    
                }
                
        }
}
