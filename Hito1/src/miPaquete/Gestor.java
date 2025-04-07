package miPaquete;
import java.util.*;

public class Gestor {
    private static Map<String, Animal> animales = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Creamos un objeto para poder leer la entrada 
        boolean salir = false;   // Controla el bucle del menú

        while (!salir) {
            System.out.println("\n1. Alta animal\n2. Buscar por chip\n3. Mostrar todos\n4. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();
         // Usamos un switch para ejecutar la opción
            switch (opcion) {
                case 1 -> altaAnimal(sc);
                case 2 -> buscarAnimal(sc);
                case 3 -> mostrarTodos();
                case 4 -> salir = true;
            }
        }
    }
// Registrar un nuevo animal
    public static void altaAnimal(Scanner sc) {
        System.out.print("Tipo (perro/gato): ");
        String tipo = sc.nextLine().toLowerCase();

        System.out.print("Chip: ");  // Pregunta por el chip
        String chip = sc.nextLine();
     // Vemos si el chip del animal esta registrado
        if (animales.containsKey(chip)) {
            System.out.println("El chip ya esta registrado y asignado.");
            return;
        }
// Pide informacion del animal
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt(); sc.nextLine();
        System.out.print("Raza: ");
        String raza = sc.nextLine();
        System.out.print("¿Adoptado? (true/false): ");
        boolean adoptado = sc.nextBoolean(); sc.nextLine();

        if (tipo.equals("perro")) {
            System.out.print("Tamaño (pequeño/mediano/grande): ");  //Vemos el tamaño del animal
            String tamaño = sc.nextLine();
            animales.put(chip, new Perro(chip, nombre, edad, raza, adoptado, tamaño));
        } else if (tipo.equals("gato")) {
            System.out.print("¿Test de leucemia positivo? (true/false): ");  //dictamos si el gato tiene leucemia o no
            boolean leucemia = sc.nextBoolean(); sc.nextLine();
            animales.put(chip, new Gato(chip, nombre, edad, raza, adoptado, leucemia));
        } else {
            System.out.println("El tipo no ha sido válido.");  // Se muestra si ha ocurrido un error
        }
    }
  // Busca el animal por el Chip
    public static void buscarAnimal(Scanner sc) {
        System.out.print("Introduzca el chip: ");
        String chip = sc.nextLine();

        Animal a = animales.get(chip);
        if (a != null) {
            a.mostrar();
        } else {
            System.out.println("El animal no ha sido encontrado.");
        }
    }
// Muestra todos los animales
    public static void mostrarTodos() {
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animal a : animales.values()) {
                a.mostrar();
            }
        }
    }
}
