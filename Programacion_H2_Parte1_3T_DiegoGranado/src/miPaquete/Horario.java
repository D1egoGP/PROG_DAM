package miPaquete;
// Almacenan los atributos 
public class Horario {
    private String fecha;
    private String hora;
    private int sala;
  // Se utiliza para arrancar los atributos
    public Horario(String fecha, String hora, int sala) {
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getSala() {
        return sala;
    }
}
