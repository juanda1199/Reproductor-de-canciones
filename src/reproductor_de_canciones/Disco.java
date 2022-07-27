
package reproductor_de_canciones;

import java.util.*; //libreria para uso de arraylists
import javax.swing.*; // libreria para interfaces
import java.io.*; // libreria para excepciones
import java.util.logging.*;
import javax.sound.sampled.*;
import javazoom.jlgui.basicplayer.*;  // libreria del basicplayer para el control de archivos mp3
import javax.swing.filechooser.FileNameExtensionFilter; // libreria para el filtro del filechooser
import org.tritonus.share.sampled.file.TAudioFileFormat;  // libreria para obtener caracteristicas de una variable

public class Disco extends JFrame implements BasicPlayerListener {
    ArrayList <Cancion> disc;
    ArrayList <File> archives ;
    DefaultListModel <String> files;
    private String tituloDisc;
    private String fechaEdicion;
    
    private BasicPlayer player = new BasicPlayer();
    File file;  // variable que representara el achivo en reproduccion
    JFileChooser fc = new JFileChooser();
    protected boolean running; // Variable que valida la si esta detenido o reproduciendo
    int mcs, hor, min, seg, open; // variables para la duracion de una cancion y open para el archivo en uso

    public Disco(){
        disc = new ArrayList <Cancion>();
        tituloDisc = "lista";
        fechaEdicion = "";
        player.addBasicPlayerListener(this);  // Agrega las metodos abstractos para su uso
    }

    BasicController control = (BasicController) player; // establece la variable para el control de los archivos mp3

    public String getTituloDisc() {
        return tituloDisc;
    }

    public String getFechaEdicion() {
        return fechaEdicion;
    }

    public void setTituloDisc(String tituloDisc) {
        this.tituloDisc = tituloDisc;
    }

    public void setFechaEdicion(String fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
    
    int hort, mint, segt;
    public void obtenerDuracionTotal(){ // Metodo para obtener la duracion total de la lista de reproduccion
        int duracionT = 0;
        
        for (int i=0; i<archives.size(); i++){ 
            String tit = files.get(i); // guarda en el string lo que hay en la posicion i de files
            File fl = archives.get(i); //Crea un archivo y asigna lo que hay en la posicion (i) de archivos 
            AudioFileFormat audioFileFormat = null;
            try {
                audioFileFormat = AudioSystem.getAudioFileFormat(fl);
            } catch (UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Disco.class.getName()).log(Level.SEVERE, null, ex);
            }
            Map <String, Object>  properties = ((TAudioFileFormat) audioFileFormat).properties();

            Long micro = (Long) properties.get("duration");
            mcs  = (int) (micro/1000);
            double dur = (double)mcs;
            Cancion c = new Cancion(tit, dur);
            disc.add(c);
            duracionT += c.getDuracion();
        }
        mint  = (int)(duracionT/10000)/6;
        segt  = (int)(duracionT/1000)%60;
        if (mint > 60){
            hort = mint/60;
            mint = mint%60;
        }
    }
    

    public void obtenerCancion (){ // metodo para crear un lista de reproduccion con un buscador jFilechooser
        
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos *MP3", "mp3");
        fc.setFileFilter(filtro);
        fc.setMultiSelectionEnabled(true);//Seleccionar multiples archivos
        files = new DefaultListModel <String>();
        archives = new ArrayList<File>();
        int seleccion = fc.showOpenDialog(this); 
        
        if (seleccion == JFileChooser.APPROVE_OPTION) { 
            for (File item : fc.getSelectedFiles()){
                files.addElement(item.getName());
                archives.add(item);
            }
            open = 0;
            file = archives.get(open); // inicia en la primera posicion del array
            duracion(); // obtiene duracion
            obtenerDuracionTotal();
            
            try { 
                control.open(file);
                control.play();
                running = true;
            } catch (BasicPlayerException ex) { 
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex); 
            }
            
        }
    }
    
    public void duracion (){ // Metodo para obtener la duracion del archivo en reproduccion
        AudioFileFormat audioFileFormat = null;
        try {
            audioFileFormat = AudioSystem.getAudioFileFormat(file);// obtiene las caracteristicas del archivo
        } catch (UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Disco.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map <String, Object>  properties = ((TAudioFileFormat) audioFileFormat).properties();

        Long micro = (Long) properties.get("duration"); // obtiene la duracion en microsegundos
        mcs  = (int) (micro/1000);

        hor  = (mcs/100000)/6;
        min  = (mcs/10000)/6;
        seg  = (mcs/1000)%60;
    }

    // Metodos abstractos del basicplayer para las propiedades del archivo mp3
    @Override
    public void opened(Object stream, Map properties) { 
    } 

    @Override
    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {  
    } 

    @Override
    public void stateUpdated(BasicPlayerEvent event) {
    } 

    @Override
    public void setController(BasicController controller) { 
    } 


    
    


    
    
    
    
}
