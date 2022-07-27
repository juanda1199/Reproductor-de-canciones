
package reproductor_de_canciones;

public class Cancion {
    private String titulo;
    private double duracion;
    
    Cancion (String titulo, double duracion){
        this.titulo = titulo;
        this.duracion = duracion;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }


    
    
}
