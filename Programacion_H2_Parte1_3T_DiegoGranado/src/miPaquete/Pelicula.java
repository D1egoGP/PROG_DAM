package miPaquete;

// estos attributos almacenan la informacion
public class Pelicula {
    private String codigo;
    private String titulo;
    private String director;
    private int duracion;
    private int año;
    private Genero genero;

    public Pelicula(String codigo, String titulo, String director, int duracion, int año, Genero genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.año = año;
        this.genero = genero;
    }

    public String getCodigo() {
        return codigo; // Devuelve el valor 
    }

    public String getTitulo() {
        return titulo; // Devuelve el valor 
    }

    public String getDirector() {
        return director; // Devuelve el valor 
    }

    public int getDuracion() {
        return duracion; // Devuelve el valor 
    }

    public int getAño() {
        return año; // Devuelve el valor 
    }

    public Genero getGenero() {
        return genero;
    }
}
