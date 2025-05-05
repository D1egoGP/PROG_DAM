package miPaquete;
import java.sql.*;
import java.util.*;

public class Principal {
// Codigo de uso para conectar a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3307/cine_diegogranado";
    private static final String USER = "root"; 
    private static final String PASS = "";     

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Lee la entrada del usuario
        int opcion;

        do { //Menu de opciones del usuario
            System.out.println("\n=== MENU DEL CINE ===");
            System.out.println("1. Ver peliculas");
            System.out.println("2. Salir");
            System.out.print("Elige una opcion: ");

            while (!sc.hasNextInt()) {
                System.out.print("Introduce un numero que sea válido: ");
                sc.next();
            }

            opcion = sc.nextInt();
 // se usa wl switch para seleccionar una opcion dependiendo de la seleccion
            switch (opcion) {
                case 1:
                    mostrarPeliculas();
                    break;
                case 2:
                    System.out.println("Hasta pronto........");
                    break;
                default:
                    System.out.println("La opcion no es incorrecta.");
            }

        } while (opcion != 2);

        sc.close();
    }
 // Muestra las pelis que estan en la base de datos
    public static void mostrarPeliculas() {
        String sql = "SELECT * FROM peliculas"; // Selecciona todas las películas

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            
            ResultSet rs = stmt.executeQuery(sql);

            // Muestra dichos resultados
            System.out.println("----- LISTA DE PELICULAS -----");
            while (rs.next()) {
                System.out.println("Código: " + rs.getString("codigo_pelicula"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Director: " + rs.getString("director"));
                System.out.println("Duración: " + rs.getInt("duracion") + " minutos");
                System.out.println("Año de estreno: " + rs.getInt("año_estreno"));
                System.out.println("Género: " + rs.getString("codigo_genero"));
                System.out.println("_______________________________");
            }

        } catch (SQLException e) { // Mensaje que dicta su ha ocurrido un error
            System.out.println("Error al conectar con la base de datos:");
            System.out.println(e.getMessage());
        }
    }
}