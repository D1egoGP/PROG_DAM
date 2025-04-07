package miPaquete;
public abstract class Animal {
    protected String Chip;
    protected String Nombre;
    protected int Edad;
    protected String Raza;
    protected boolean Adoptado;
 // Sobrecarga de Constructores como la que se ha visto en el Modulo 4  
    public Animal(String Chip, String Nombre, int Edad, String Raza, boolean Adoptado) {
        this.Chip = Chip;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.Raza = Raza;
        this.Adoptado = Adoptado;
        // 
    } //accede al chip desde fuera 
    public String getChip() { 
        return Chip;
    }
    public abstract void mostrar();  // Muestra la informacion de dicho animal
}



