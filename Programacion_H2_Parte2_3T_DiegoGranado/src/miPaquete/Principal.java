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
            System.out.println("=== MENU DEL CINE ===");
            System.out.println("1. Ver peliculas");
            System.out.println("2. Editar pelicula");
            System.out.println("3. Añadir pelicula");
            System.out.println("4. Eliminar pelicula");
            System.out.println("5. Salir");
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
                editarPelicula();
                break;
            case 3:
                anadirPelicula(sc);
                break;
            case 4:
                eliminarPelicula(sc);
                break;
            case 5:
                System.out.println("Hasta pronto........");
                break;
            default:
                System.out.println("La opcion no es valida");
        }

    } while (opcion != 5);

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
        

    public static void editarPelicula() {
        Scanner sc = new Scanner(System.in);
        System.out.println("|---> EDITAR UNA PELICULA <---|");
        System.out.print("Introduce el codigo de la pelicula que desea editar: ");
        String codigo = sc.nextLine();
     // consulta sql para buscar la pelicula por codigo
        String sqlBuscar = "SELECT * FROM peliculas WHERE codigo_pelicula = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement psBuscar = con.prepareStatement(sqlBuscar)) {

            psBuscar.setString(1, codigo);
            ResultSet rs = psBuscar.executeQuery();
         // muestra los datos actuales y se solicitan los nuevos
            if (rs.next()) {
                System.out.print("Nuevo titulo (" + rs.getString("titulo") + "): ");
                String nuevoTitulo = sc.nextLine();

                System.out.print("Nuevo director (" + rs.getString("director") + "): ");
                String nuevoDirector = sc.nextLine();

                System.out.print("Nueva duracion (" + rs.getInt("duracion") + "): ");
                int nuevaDuracion = Integer.parseInt(sc.nextLine());

                System.out.print("Nuevo año (" + rs.getInt("año_estreno") + "): ");
                int nuevoAño = Integer.parseInt(sc.nextLine());
             // actualiza los datos de las peliculas
                String sqlUpdate = "UPDATE peliculas SET titulo = ?, director = ?, duracion = ?, año_estreno = ? WHERE codigo_pelicula = ?";
                try (PreparedStatement psUpdate = con.prepareStatement(sqlUpdate)) {
                    psUpdate.setString(1, nuevoTitulo);
                    psUpdate.setString(2, nuevoDirector);
                    psUpdate.setInt(3, nuevaDuracion);
                    psUpdate.setInt(4, nuevoAño);
                    psUpdate.setString(5, codigo);

                    int filas = psUpdate.executeUpdate();
                    if (filas > 0) {
                        System.out.println("La pelicula fue modificada correctamente");
                    } else {
                        System.out.println("No se pudo actualizar la pelicula");
                    }
                }
            } else { // mensaje que salta si no se encuentra ninguna pelicula con ese codigo
                System.out.println("No se encontro ninguna pelicula que corresponda a dicho codigo");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar modificar la pelicula" + e.getMessage());
        }
    }


    public static void anadirPelicula(Scanner sc) {
        System.out.println("|---> AÑADIR UNA PELICULA <---|");
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Codigo de la pelicula: ");
            sc.nextLine(); // limpia el salto de linea
            String codigo = sc.nextLine();
            // comprueba si ya existe una pelicula con el mismo codigo
            String checkSql = "SELECT * FROM peliculas WHERE codigo_pelicula = ?";
            try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
                checkStmt.setString(1, codigo);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Ya existe una pelicula con dicho codigo");
                    return;
                }
            }
            // recoge los datos de las peliculas
            System.out.print("Titulo: ");
            String titulo = sc.nextLine();
            System.out.print("Director: ");
            String director = sc.nextLine();
            System.out.print("Duracion: ");
            int duracion = Integer.parseInt(sc.nextLine());
            System.out.print("Año de estreno: ");
            int anio = Integer.parseInt(sc.nextLine());
            System.out.print("Codigo de genero: ");
            String genero = sc.nextLine();
            // se insertan los valores en la tabla, cada interrogacion corresponde a un valor
            String insertSql = "INSERT INTO peliculas VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = con.prepareStatement(insertSql)) {
                insertStmt.setString(1, codigo);
                insertStmt.setString(2, titulo);
                insertStmt.setString(3, director);
                insertStmt.setInt(4, duracion);
                insertStmt.setInt(5, anio);
                insertStmt.setString(6, genero);

                int filas = insertStmt.executeUpdate();
                if (filas > 0) {
                    System.out.println("La pelicula fue añadida correctamente");
                }
            }
        } catch (SQLException e) { // mensaje por si ocurre algun error
            System.out.println("Error al añadir la pelicula" + e.getMessage());
        }
    }

    
    public static void eliminarPelicula(Scanner sc) {
        System.out.println("|---> ELIMINAR UNA PELICULA <---|"); 
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.print("Inserte el codigo de la pelicula que desea que sea eliminada: ");
            sc.nextLine(); // limpia el salto delinea
            String codigo = sc.nextLine();

            // comprobamos si existe una pelicula con ese codigo
            String checkSql = "SELECT * FROM peliculas WHERE codigo_pelicula = ?";
            try (PreparedStatement checkStmt = con.prepareStatement(checkSql)) {
                checkStmt.setString(1, codigo);
                ResultSet rs = checkStmt.executeQuery();

                if (!rs.next()) {
                    System.out.println("No se encontro ninguna pelicula con el codigo: " + codigo);
                    return;
                }
            }

            // elimina funciones relacionadas (realizado por probelmas del sql y consultado)
            String deleteFuncionesSql = "DELETE FROM funciones WHERE codigo_pelicula = ?";
            try (PreparedStatement deleteFunciones = con.prepareStatement(deleteFuncionesSql)) {
                deleteFunciones.setString(1, codigo);
                deleteFunciones.executeUpdate();
            }

            // eliminacion de la pelicula
            String deletePeliculaSql = "DELETE FROM peliculas WHERE codigo_pelicula = ?";
            try (PreparedStatement deletePelicula = con.prepareStatement(deletePeliculaSql)) {
                deletePelicula.setString(1, codigo);
                int filas = deletePelicula.executeUpdate();

                if (filas > 0) {
                    System.out.println("La pelicula fue eliminada con exito");
                } else {
                    System.out.println("No se encontro ninguna pelicula con el codigo: " + codigo);
                }
            }

        } catch (SQLException e) { // mensaje por si salta algun error
            System.out.println("Error al intentar eliminar la pelicula: " + e.getMessage());
        }
    }



    
}