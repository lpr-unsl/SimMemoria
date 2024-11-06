
package memapplication;
import java.io.*;

public class leer {
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;
    
    public leer(){
    
    
    }
    public String MostrarTexto(File archivo){
    String contenido=" ";
    
    try {
    entrada = new FileInputStream(archivo);
    int ascci;
            while ((ascci = entrada.read()) != -1) {
            char caracter =(char)ascci;
            contenido += caracter;
             //System.out.println("a verrr:"+contenido);
            }
    }catch (Exception e){
    }
 
    return contenido;
    }
}
