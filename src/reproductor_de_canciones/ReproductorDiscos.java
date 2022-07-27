
package reproductor_de_canciones;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javazoom.jlgui.basicplayer.*;  // libreria del basicplayer para el control de archivos mp3

public class ReproductorDiscos {
    Disco mizplayer = new Disco();  
    ArrayList <File> disc;
    DefaultListModel <String> filed;

    
    public void reproducir(){ // Metodo para reproducir
        if (!mizplayer.running&&mizplayer.file!=null) { 
            try { 
                mizplayer.control.play(); // reproduce el archivo si running es falso y ahi un archivo abierto
                mizplayer.running = true; // vuelve running verdadero para demostrar que esta reproduciendo
            } catch (BasicPlayerException ex) { 
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex); 
            } 
        }  
        if (mizplayer.running) { 
            try { 
                mizplayer.control.resume(); // en caso de que running sea verdadero, continua la cancion donde quedo
            } catch (BasicPlayerException ex) { 
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex); 
            }
        }
    }
    
    public void pausar (){
        try { 
            mizplayer.control.pause(); // pausa la cancion
        } catch (BasicPlayerException ex) { 
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
    
    public void detener (){ // Metodo para detener y reiniciar la cancion actual
        try { 
            mizplayer.control.stop(); // detiene la cancion
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        mizplayer.running = false; // Vuelve running falso para demostrar que se a detenido y reiniciar la cancion cuando la reproduzca
    }
    
    public void siguiente (){ // metodo para pasar al siguiente archivo en la lista de reproduccion
        if (mizplayer.open < mizplayer.archives.size()-1){ // valida si el archivo abierto es menor al tamaño del array 
            try {
                mizplayer.control.stop(); // detiene la cancion
                mizplayer.open += 1;
                mizplayer.file = mizplayer.archives.get(mizplayer.open); // toma el archivo siguiente en la lista
                mizplayer.control.open(mizplayer.file); //abre el archivo
                mizplayer.control.play(); // lo reproduce
                mizplayer.running = true;
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorDiscos.class.getName()).log(Level.SEVERE, null, ex);
            }
            mizplayer.duracion(); // obtiene la duracion
        }  else { // en caso contrario, vuelve al principio
            try {
                mizplayer.control.stop();
                mizplayer.open = 0;
                mizplayer.file = mizplayer.archives.get(mizplayer.open); // toma la primera cancion
                mizplayer.control.open(mizplayer.file);
                mizplayer.control.play();
                mizplayer.running = true;
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorDiscos.class.getName()).log(Level.SEVERE, null, ex);
            }
            mizplayer.duracion();
        } 
    }
    
    public void anterior (){ // metodo para pasar al anterior archivo en la lista de reproduccion
        if (mizplayer.open > 0){ // valida si el archivo abierto es mayor al primero de la lista
            try {
                mizplayer.control.stop();
                mizplayer.open -= 1;
                mizplayer.file = mizplayer.archives.get(mizplayer.open);
                mizplayer.control.open(mizplayer.file);
                mizplayer.control.play();
                mizplayer.running = false;
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorDiscos.class.getName()).log(Level.SEVERE, null, ex);
            }
            mizplayer.duracion();
        } else {
            try { // en caso contrario, abre el ultimo archivo del array
                mizplayer.control.stop();
                mizplayer.open = mizplayer.archives.size()-1;
                mizplayer.file = mizplayer.archives.get(mizplayer.open);
                mizplayer.control.open(mizplayer.file);
                mizplayer.control.play();
                mizplayer.running = false;
            } catch (BasicPlayerException ex) {
                Logger.getLogger(ReproductorDiscos.class.getName()).log(Level.SEVERE, null, ex);
            }
            mizplayer.duracion();
        }
    }
    
    public void guardarDisc(){ // metodo para guardar la lista de reproduccion
        disc = new ArrayList <File>(mizplayer.archives);
        filed = new DefaultListModel <String>();
        disc = mizplayer.archives; // 
        for(File itm : disc){
            filed.addElement(itm.getName());
        }
    }
    
    public void cargarDisc () { // metodo para abrir la lista de reproduccion guardada
        mizplayer.archives = disc;
        mizplayer.files = filed;
        mizplayer.open = 0;
        mizplayer.file = disc.get(mizplayer.open);
        try { 
            mizplayer.control.open(mizplayer.file);
            mizplayer.control.play();
            mizplayer.running = true;
            
        } catch (BasicPlayerException ex) { 
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex); 
        }
        mizplayer.duracion();
        mizplayer.obtenerDuracionTotal();
    }
    
    public void agregar (){ // metodo para agregar canciones a la lista
        int seleccion = mizplayer.fc.showOpenDialog(null); // abre el buscador
        if (seleccion == JFileChooser.APPROVE_OPTION) { 
            for (File item : mizplayer.fc.getSelectedFiles()){ // agrega los archivos seleccionados a los arrays 
                mizplayer.files.addElement(item.getName());
                mizplayer.archives.add(item);
            }
        }
        mizplayer.obtenerDuracionTotal();
    }
    
}
