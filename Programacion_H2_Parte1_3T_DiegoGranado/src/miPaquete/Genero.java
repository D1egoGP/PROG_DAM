package miPaquete;

public class Genero {
    private String codigo;
    private String nombre;

    public Genero(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }
}
