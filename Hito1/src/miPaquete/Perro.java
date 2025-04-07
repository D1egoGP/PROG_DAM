package miPaquete;
public class Perro extends Animal {
    private String Tamaño;
    public Perro(String Chip, String Nombre, int Edad, String Raza, boolean Adoptado, String Tamaño) {
        super(Chip, Nombre, Edad, Raza, Adoptado);
        this.Tamaño = Tamaño;
    }
    @Override
    public void mostrar() {     // Muestra la informacion de dicho animal, y dicta el tamaño del perro
        System.out.println("Chip: " + Chip + ", Nombre: " + Nombre + ", Edad: " + Edad +  ", Raza: " + Raza + ", Adoptado: " + Adoptado + ", Tamaño: " + Tamaño);
    }
}
