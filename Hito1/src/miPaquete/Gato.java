package miPaquete;

public class Gato extends Animal {
	private boolean Testleucemia;   //Dictar las caracteristicas del animal 
	public Gato(String Chip, String Nombre, int Edad, String Raza, boolean Adoptado, boolean Testleucemia) {
        super(Chip, Nombre, Edad, Raza, Adoptado);
        this.Testleucemia = Testleucemia;
	}
        @Override
        public void mostrar() {    // Muestra la informacion de dicho animal, dice si tiene leucemia o no
            System.out.println("Chip: " + Chip + ", Nombre: " + Nombre + ", Edad: " + Edad +  ", Raza: " + Raza + ", Adoptado: " + Adoptado + ", Testleucemia: " + (Testleucemia? "Sí" : "No"));
        }
	  
}
	